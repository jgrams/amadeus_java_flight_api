import React, { useState } from "react";

function Order(props) {
    const [dob, setDob] = useState("1982-01-16");
    const [fname, setFname] = useState("Harryette");
    const [lname, setLname] = useState("Mullen");
    const [gender, setGender] = useState("FEMALE");
    const [document, setDocument] = useState([{
        documentType: "PASSPORT",
        birthPlace: "Madrid",
        issuanceLocation: "Madrid",
        issuanceDate: "2015-04-14",
        number: "00000000",
        expiryDate: "2025-04-14",
        issuanceCountry: "ES",
        validityCountry: "ES",
        nationality: "ES",
        holder: true
      }]);
      const [contact, setContact] = useState({
        phones: [
          {
            countryCallingCode: "33",
            number: "487692704",
            deviceType: "MOBILE"
          }
        ]
      });

    function submit(event, props){
        event.preventDefault(); 
        fetch("api/order/", {
            method: "post",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                data: {
                    type: "flight-order",
                    flightOffers: props.confirmation.flightOffers,
                    travelers: [{
                        id: 1,
                        dateOfBirth: dob,
                        name: {
                            firstName: fname,
                            lastName: lname
                        },
                        gender: gender,
                        contact: contact,
                        documents: document
                    }]
                }
            })
        })
        .then((response) => response.json())
        .then((json) => {
            props.setOrder(json);
        });
    }

    return (
        <div>
            <form onSubmit={(e) => submit(e, props)}>
                <label htmlFor="dob">Date of Birth:</label>
                <input type="date"
                    onChange={(e) => setDob(e.target.value)} 
                    id="dob" 
                    name="dob" 
                    required /><br></br>
                <label>First Name: </label>
                <input value={fname} onChange={(e) => setFname(e.target.value)} required></input><br></br>
                <label>Last Name: </label>
                <input value={lname} onChange={(e) => setLname(e.target.value)} required></input><br></br>
                <label>Gender: </label>
                <select onChange={(e) => setGender(e.target.value)}>
                    <option value="FEMALE">Female</option>
                </select><br></br>
                <input type="submit" />
            </form>
            { props.order &&
                <div>
                    <div>Flight Booked!</div>
                    <div>{props.order}</div> 
                </div>
            }
        </div>
    );
};

export default Order;
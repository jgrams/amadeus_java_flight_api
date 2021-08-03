import React from "react";

function FlightSelect(props) {
    const options = props.flightOptions.map((flight, index) =>  
      <>
        <input type="radio" id={flight.id} name="select" value={index} />
        <label htmlFor={flight.id}>
            {"Price: " + flight.price.grandTotal + " " + flight.price.currency}
        </label>
        <div>
            Available Seats: {flight.numberOfBookableSeats}
        </div>
        <div>
            One Way?: {flight.oneWay ? "True" : "False"} 
        </div><br></br>
      </>
    );

    return (
      <div>
        {props.flightOptions.length > 0 &&
          <form onChange={(e) => props.setFlight(props.flightOptions[e.target.value])}>
            {options}
          </form>
        }
      </div>
    );
}

export default FlightSelect;
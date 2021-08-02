import React from "react";

function LocationSelect(props) {
    const options = props.data.map((location) =>  
      <>
        <input type="radio" id={location.iataCode} name="select" value={location.iataCode} />
        <label htmlFor={location.iataCode}>
            {location.name + ": " + location.iataCode}
        </label><br></br>
      </>
    );

    return (
      <div>
        {props.data.length > 0 &&
          <form onChange={props.handleChoice}>
            {options}
          </form>
        }
      </div>
    );
}

export default LocationSelect;
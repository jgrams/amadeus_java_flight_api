import React, { useState } from "react";
import TextInput from './TextInput';
import LocationSelect from './LocationSelect'

function Locate(props) {
    const [value, setValue] = useState('');
    const [locations, setLocations] = useState([]);

    const submit = (e) => {
        e.preventDefault();
        fetch(
            "/api/locations?keyword=" + value
        )
        .then((response) => response.json())
        .then((json) => {
          setLocations(json);
        });
    }

    return (
        <div>
            <TextInput onSubmit={submit} display={props.display} onChange={(e) => setValue(e.target.value)} value={value} />
            <LocationSelect data={locations} handleChoice={props.handleChoice} />
        </div>
    );
};

export default Locate;
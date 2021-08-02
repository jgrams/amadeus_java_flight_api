import React from "react";

const TextInput = props => (
  <form onSubmit={props.onSubmit}>
    <label>{props.display}: </label>
    <input value={props.value} onChange={props.onChange}></input>
    <input type="submit"></input>
  </form>
);

export default TextInput;
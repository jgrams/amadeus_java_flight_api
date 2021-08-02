import React, { useState } from 'react'
import Locate from './components/Locate';

export default function App() {
  const [origin, setOrigin] = useState('');
  const [destination, setDestination] = useState('');

  const originate = (e) => {
    setOrigin(e.target.value);
  }

  const destinate = (e) => {
    setDestination(e.target.value);
  }

  return (
    <div>
      <Locate handleChoice={originate} display={"Destination"}/>
      <Locate handleChoice={destinate} display={"Origin"}/>
    </div>
  )
}
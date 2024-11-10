import React from 'react';
import { useState } from 'react';

export default function InputTextShow() {
  const [data, setData] = useState(null);

  function handleChange(e) {
    const inputText = e.target.value;

    setData(() => {
      return <div>{inputText}</div>;
    });
  }

  return (
    <>
      <input type="text" onChange={handleChange}></input>
      {data}
    </>
  );
}

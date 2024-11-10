import React from 'react';
import { useState } from 'react';

export default function InputColorShow() {
  const [data, setData] = useState(null);

  function handleChange(e) {
    const inputText = e.target.value;

    setData(<div style={{ color: inputText }}>{inputText}</div>);
    // setData(() => {
    //   return <div style={{ color: inputText }}>{inputText}</div>;
    // });
  }

  return (
    <>
      <input type="text" onChange={handleChange}></input>
      {data}
    </>
  );
}

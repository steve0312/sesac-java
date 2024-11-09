import React from 'react';

export default function InputText() {
  function handleChange(e) {
    console.log('입력 : ', e.target.value);
  }

  return <input type="text" onChange={handleChange}></input>;
}

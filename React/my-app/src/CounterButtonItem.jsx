import React from 'react';

export default function CounterButtonItem(props) {
  // console.log("props : ", props);
  const { children, handleButtonClick } = props;

  return <button onClick={handleButtonClick}>{children}</button>;
}

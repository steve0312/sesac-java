import React from 'react';

export default function ButtonClick() {
  function handleClick() {
    alert('버튼 클릭');
  }

  return <button onClick={handleClick}>버튼</button>;
}

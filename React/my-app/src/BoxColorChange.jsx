import React from 'react';

export default function BoxColorChange() {
  function handleMouseEnter(e) {
    e.target.style.backgroundColor = 'black';
  }

  function handleMouseLeave(e) {
    e.target.style.backgroundColor = 'white';
  }

  return (
    <div
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
      style={{ width: 100, height: 100, border: '1px solid black' }}
    ></div>
  );
}

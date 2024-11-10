import React from 'react';
import { useState } from 'react';

export default function GoodChange() {
  const [text, setText] = useState('좋아요');
  const [bgColor, setColor] = useState('blue');

  function handleButtonClick(e) {
    const myText = e.target.textContent;

    setText(myText === '좋아요' ? '좋아요 취소' : '좋아요');
    setColor(myText === '좋아요' ? 'red' : 'blue');
  }
  return (
    <>
      <button onClick={handleButtonClick} style={{ backgroundColor: bgColor }}>
        {text}
      </button>
    </>
  );
}

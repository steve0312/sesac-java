import React from 'react';
import { useState } from 'react';

export default function Counter() {
  const [num, setNum] = useState(0);

  function handleMinusClick() {
    // 0보다 작을 경우, 버튼을 다시 입력하도록 안내하는 문구 설정
    num > 0
      ? setNum((prev) => prev - 1)
      : alert('0보다 작으면 안됩니다. 다시 입력하세요!');
  }

  function handlePlusClick() {
    setNum((prev) => prev + 1);
  }

  return (
    <>
      <div>{`숫자 : ${num}`}</div>
      <button onClick={handleMinusClick}>-</button>
      <button onClick={handlePlusClick}>+</button>
    </>
  );
}

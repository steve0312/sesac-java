import React from 'react';
import { useState } from 'react';
import CounterButtonItem from './CounterButtonItem';

export default function CounterButton() {
  const [num, setNum] = useState(0);

  // function handleMinusClick() {
  //   num > 0
  //     ? setNum((prev) => prev - 1)
  //     : alert("0보다 작으면 안됩니다. 다시 입력하세요!");
  // }

  // function handlePlusClick() {
  //   setNum((prev) => prev + 1);
  // }

  return (
    <>
      <div>{`숫자 : ${num}`}</div>
      <Button
        handleButtonClick={() =>
          num > 0
            ? setNum((prev) => prev - 1)
            : alert('0보다 작으면 안됩니다. 다시 입력하세요!')
        }
      >
        -
      </Button>
      <Button handleButtonClick={() => setNum((prev) => prev + 1)}>+</Button>
    </>
  );
}

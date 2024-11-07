import React from 'react';
import Buttons from './Buttons';

export default function ButtonContainer() {
  const buttonData = [
    { backgroundColor: 'blue', text: '확인' },
    { backgroundColor: 'tomato', text: '취소' },
    { backgroundColor: 'gray', text: '보류' },
    { backgroundColor: 'violet', text: '1억년' },
  ];

  const buttons = buttonData.map((button) => {
    const { backgroundColor, text, color } = button;
    return (
      <Buttons color={color} backgroundColor={backgroundColor}>
        {text}
      </Buttons>
    );
  });

  return (
    <div>
      {/* <Button backgroundColor="blue">확인</Button>
      <Button backgroundColor="blue">확인</Button>
      <Button backgroundColor="blue">확인</Button> */}
      {buttons}
    </div>
  );
}

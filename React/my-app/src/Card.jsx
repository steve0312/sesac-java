import React from 'react';

export default function Card({ title, content, width, height }) {
  return (
    // 구조 분해 할당으로 변수를 지정했기 때문에 아래 처럼도 사용 가능 (단축 프로퍼티)
    // <div style={{ width, height, backgroundColor: "lightgreen" }}>
    <div
      style={{ width: width, height: height, backgroundColor: 'lightgreen' }}
    >
      <h1>{title}</h1>
      <p>{content}</p>
    </div>
  );
}

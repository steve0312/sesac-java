import React from 'react';

export default function List1() {
  const arr1 = [
    {
      name: 'jun',
      age: 18,
    },
    {
      name: 'alex',
      age: 28,
    },
    {
      name: 'ken',
      age: 38,
    },
    {
      name: 'beemo',
      age: 48,
    },
    {
      name: 'lynda',
      age: 8,
    },
  ];

  // age가 30 이하인 사람들의 정보가 담긴 array를 만들어보자
  const newArr1 = arr1.filter((el) => {
    return el.age <= 30;
  });

  return <div>{newArr1}</div>;
}

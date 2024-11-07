import React from 'react';

export default function List2() {
  const arr2 = [
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

  // age가 30 이하인 사람들의 이름이 담긴 array를 만들어보자.
  const newArr2 = arr2.filter((el) => el.age <= 30).map((el) => el.name);

  return <div>{newArr2}</div>;
}

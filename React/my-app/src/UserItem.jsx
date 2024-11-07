import React from 'react';

export default function UserItem({ id, name, age, hobby }) {
  return (
    <li>
      <div>id : {id}</div>
      <div>name : {name}</div>
      <div>age : {age}</div>
      <div>hobby : {hobby}</div>
    </li>
  );
}

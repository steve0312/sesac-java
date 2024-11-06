import React from 'react';

export default function Button({ backgroundColor, text }) {
  return <button style={{ backgroundColor, color: 'white' }}>{text}</button>;
}

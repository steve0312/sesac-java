import React from 'react';

export default function Button({ backgroundColor, color = 'white', children }) {
  return <button style={{ backgroundColor, color }}>{children}</button>;
}

import React from 'react';
import { Link } from 'react-router-dom';

export default function Home() {
  return (
    <>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/posts">posts</Link>
        </li>
      </ul>
      <div>Home</div>
    </>
  );
}

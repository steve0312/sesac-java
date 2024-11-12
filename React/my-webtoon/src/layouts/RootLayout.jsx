import React from 'react';
import { Link, Outlet } from 'react-router-dom';

export default function RootLayout() {
  return (
    <>
      <header>
        <ul>
          {/* <li>
          <Link to="/">홈</Link>
        </li> */}
          <li>
            <Link to="/webtoon">웹툰</Link>
          </li>
          <li>
            <Link to="/novel">소설</Link>
          </li>
        </ul>
      </header>
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}

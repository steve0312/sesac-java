import React from 'react';
import { Link } from 'react-router-dom';

export default function RootHeader() {
  return (
    <header>
      <ul className="dotNone displays spaceAround borders">
        {/* <li>
          <Link to="/">홈</Link>
        </li> */}
        <li>
          <Link to="/webtoon" className="linkNone textColor">
            웹툰
          </Link>
        </li>
        <li>
          <Link to="/novel" className="linkNone textColor">
            소설
          </Link>
        </li>
      </ul>
    </header>
  );
}

import React from 'react';
import { Link } from 'react-router-dom';

export default function WebtoonHeader() {
  const days = ['월', '화', '수', '목', '금', '토', '일'];
  return (
    <header>
      <ul>
        <li>
          <Link to="/">메인</Link>
        </li>
        {days.map((day) => {
          return (
            <li key={day}>
              <Link to={`/webtoon/${day}`}>{day}</Link>
            </li>
          );
        })}
      </ul>
    </header>
  );
}

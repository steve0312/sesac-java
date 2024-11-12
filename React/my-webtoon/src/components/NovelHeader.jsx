import React from 'react';
import { Link } from 'react-router-dom';

export default function NovelHeader() {
  const genres = ['무협', 'SF', '판타지', '로맨스', '공포', '코미디'];

  return (
    <header>
      <ul>
        <li>
          <Link to="/">메인</Link>
        </li>
        {genres.map((genre) => {
          return (
            <li>
              <Link to={`/novel/${genre}`}>{genre}</Link>
            </li>
          );
        })}
      </ul>
    </header>
  );
}

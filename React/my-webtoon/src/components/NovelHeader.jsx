import React from 'react';
import { Link } from 'react-router-dom';

export default function NovelHeader() {
  const genres = ['무협', 'SF', '판타지', '로맨스', '공포', '코미디'];

  return (
    <header>
      <ul className="dotNone displays spaceAround borders">
        <li>
          <Link to="/" className="linkNone textColor">
            메인
          </Link>
        </li>
        {genres.map((genre) => {
          return (
            <li key={genre}>
              <Link to={`/novel/${genre}`} className="linkNone textColor">
                {genre}
              </Link>
            </li>
          );
        })}
      </ul>
    </header>
  );
}

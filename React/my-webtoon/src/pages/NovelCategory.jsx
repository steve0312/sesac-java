import React from 'react';
import { useParams } from 'react-router-dom';

export default function NovelCategory() {
  const { genreId } = useParams();
  return (
    <div>
      <h2>{`${genreId} 장르 소설`}</h2>
    </div>
  );
}

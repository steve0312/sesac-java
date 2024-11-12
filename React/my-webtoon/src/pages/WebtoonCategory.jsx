import React from 'react';
import { useParams } from 'react-router-dom';

export default function WebtoonCategory() {
  const { dayId } = useParams();
  return (
    <div>
      <h2>{`${dayId}요일 웹툰`}</h2>
    </div>
  );
}

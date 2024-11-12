import React from 'react';
import { useLocation, useParams } from 'react-router-dom';

export default function PostDetail() {
  const { postId } = useParams();

  // useLocation을 통해 PostDetail에서 받은 post를 활용
  const location = useLocation();
  const { post } = location.state;

  return (
    <div>
      <h3>{post.title}</h3>
      <p>{post.content}</p>
    </div>
  );
}

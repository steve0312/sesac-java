import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';

export default function PostDetail() {
  const { postId } = useParams();
  // useSelector를 통해 store에 정의된 posts를 가져옴
  const posts = useSelector((state) => state.posts);

  // 위에서 이렇게 어떤 게시글(Post)을 가져올건지 미리 정하면 렌더링 때 정상 작동함
  // const post = posts.find((post) => post.id === parseInt(postId));
  const [post, setPost] = useState();

  useEffect(() => {
    setPost(posts.find((post) => post.id === parseInt(postId)));
  }, []);

  return (
    <div>
      detail
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}

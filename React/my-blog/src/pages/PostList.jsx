import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

function PostList() {
  // useSelector를 통해 store에 정의된 posts를 가져옴
  // const posts = useSelector((state) => state.posts);

  const [posts, setPosts] = useState([]);

  useEffect(() => {
    async function fetchPost() {
      const url = 'http://localhost:3000/posts';
      const response = await axios.get(url);
      // const response = await axios({url: url});

      const data = response.data;
      setPosts(data);
    }
    fetchPost();
  }, []);

  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          return (
            <li key={post.id}>
              <Link to={`/posts/${post.id}`} state={{ post }}>
                <h3>{post.title}</h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default PostList;

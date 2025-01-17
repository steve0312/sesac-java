import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import postApi from "../api/postsApi";

export default function PostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchPosts() {
      try {
        // 정상 로직
        const response = await postApi.getPosts();
        const data = response.data;

        setPosts(data.data);
      } catch (err) {
        // 에러가 발생했을 시
        setError(err.message);
        console.error(err.responase);
      } finally {
        // 정상이든 에러든 응답은 완료되었으므로 로딩은 끝난다.
        // 어떤 경우든 실행되어야 하므로 finally 에 설정
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          const { id, title } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`}>
                <h3>
                  {id} : {title}
                </h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}

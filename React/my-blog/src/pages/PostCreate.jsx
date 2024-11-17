import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addPost } from '../store/slices/postsSlice';
import { useNavigate } from 'react-router-dom';

export default function PostCreate() {
  const { isLoggedIn } = useSelector((state) => state.auth);
  const [formData, setFormData] = useState({ title: '', content: '' });
  const dispatch = useDispatch();
  const navigate = useNavigate();

  // 게시글 생성 페이지에서 로그아웃 상태로 전환 시 홈 화면으로 이동
  // 로그아웃 상태에서 URL을 통해서 직접 게시글 생성 페이지로 이동하려고 해도 홈 화면으로 이동
  useEffect(() => {
    if (!isLoggedIn) {
      navigate('/');
    }
  }, [isLoggedIn]);

  function handleChange(e) {
    const inputValue = e.target.value;
    const key = e.target.name;
    // input의 value로 state를 변경
    setFormData({
      ...formData,
      // key를 변수로서 활용 가능
      [key]: inputValue,
    });
  }

  function handleSubmit(e) {
    // 폼 제출하는 동작을 중지
    e.preventDefault();
    // id 값을 사용하기 위해 임시로 현재 시간을 넣어줌
    const id = Date.now();
    dispatch(addPost({ ...formData, id }));
    navigate(`/posts/${id}`);
  }

  return (
    <>
      <h3>PostCreate</h3>
      <form onSubmit={handleSubmit}>
        <label htmlFor="title">제목 : </label>
        <input
          type="text"
          name="title"
          id="title"
          // input 태그에 입력이 되었을 때 state를 변경
          onChange={handleChange}
        ></input>

        <label>
          내용 :
          <textarea name="content" id="" onChange={handleChange}></textarea>
        </label>

        <button>제출</button>
      </form>
    </>
  );
}

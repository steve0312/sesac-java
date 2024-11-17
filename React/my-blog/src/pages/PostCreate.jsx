import React, { useState } from 'react';

export default function PostCreate() {
  const [formData, setFormData] = useState({ title: '', content: '' });

  function handleChange(e) {
    const inputValue = e.target.value;
    const key = e.target.name;
    // input의 value로 state를 변경한다.
    setFormData({
      ...formData,
      // key를 변수로서 활용 가능
      [key]: inputValue,
    });
  }

  function handleSubmit(e) {
    e.preventDefault();
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
          // input 태그에 입력이 되었을 때 state를 변경한다.
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

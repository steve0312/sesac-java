import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import Header from './components/Header';

// 고정 header, footer 를 설정하고 콘텐츠 영역을 Outlet으로 설정해서 이동할 페이지를 연결
export default function RootLayout() {
  return (
    <>
      <Header></Header>
      {/* 부모 라우트가 자식 라우트를 렌더링할 위치를 지정하기 위해 Outlet 설정 */}
      <Outlet></Outlet>
      <footer>footer</footer>
    </>
  );
}

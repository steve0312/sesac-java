import React from 'react';
import { Outlet } from 'react-router-dom';
import NovelHeader from '../components/NovelHeader';
import Footer from '../components/Footer';

export default function NovelLayout() {
  return (
    <>
      <h2>소설</h2>
      <NovelHeader></NovelHeader>
      <Outlet></Outlet>
    </>
  );
}

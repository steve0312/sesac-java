import React from 'react';
import { Outlet } from 'react-router-dom';
import WebtoonHeader from '../components/WebtoonHeader';
import Footer from '../components/Footer';

export default function WebtoonLayout() {
  return (
    <>
      <h2>웹툰</h2>
      <WebtoonHeader></WebtoonHeader>
      <Outlet></Outlet>
    </>
  );
}

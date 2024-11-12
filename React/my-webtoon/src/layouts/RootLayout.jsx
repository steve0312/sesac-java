import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import RootHeader from '../components/RootHeader';
import Footer from '../components/Footer';

export default function RootLayout() {
  return (
    <>
      <h2 className="neverTextColor textCenter">Never</h2>
      <RootHeader></RootHeader>
      <Outlet></Outlet>
      <Footer></Footer>
    </>
  );
}

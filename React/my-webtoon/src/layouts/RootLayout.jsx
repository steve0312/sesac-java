import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import RootHeader from '../components/RootHeader';
import Footer from '../components/Footer';

export default function RootLayout() {
  return (
    <>
      <RootHeader></RootHeader>
      <Outlet></Outlet>
      <Footer></Footer>
    </>
  );
}

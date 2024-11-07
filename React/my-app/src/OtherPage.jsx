import React from 'react';
import AdminPage from './AdminPage';
import ManagerPage from './ManagerPage';
import UserPage from './UserPage';

export default function OtherPage() {
  const userType = 'admin';
  let renderingPage;

  if (userType === 'admin') {
    renderingPage = <AdminPage></AdminPage>;
  } else if (userType === 'manager') {
    renderingPage = <ManagerPage></ManagerPage>;
  } else if (userType === 'user') {
    renderingPage = <UserPage></UserPage>;
  }

  return (
    <>
      <h1>나의 앱2</h1>
      {renderingPage}
    </>
  );
}

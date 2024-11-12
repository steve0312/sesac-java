import React from 'react';
import { RouterProvider } from 'react-router-dom';
import router from './router';

export default function App() {
  return (
    <>
      {/* RouterProvider 를 통해 하나의 페이지에서 상황에 따라 여러 Component를 보여줄 수 있다. */}
      <RouterProvider router={router}></RouterProvider>
    </>
  );
}

import React from 'react';
import { RouterProvider } from 'react-router-dom';
import router from './router';

import { Provider } from 'react-redux';
import store from './store/store';

export default function App() {
  return (
    <>
      {/* store를 사용할 수 있도록 Provider 설정 */}
      <Provider store={store}>
        {/* RouterProvider 를 통해 하나의 페이지에서 상황에 따라 여러 Component를 보여줄 수 있다. */}
        <RouterProvider router={router}></RouterProvider>
      </Provider>
    </>
  );
}

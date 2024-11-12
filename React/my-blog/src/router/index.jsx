import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import PostList from '../pages/PostList';
import RootLayout from '../RootLayout';
import PostDetail from '../pages/PostDetail';

// createBrowserRouter() 를 통해 URL 경로와 컴포넌트를 매핑시킬 수 있다.
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    // children을 통해 중첩된 라우트를 지정
    children: [
      {
        // path: '/',
        // index : true를 지정해서 부모와 같은 path를 갖게 설정
        index: true,
        element: <Home />,
      },
      {
        path: '/posts',
        element: <PostList />,
      },
      {
        path: '/posts/:postId',
        element: <PostDetail />,
      },
    ],
  },
]);

export default router;

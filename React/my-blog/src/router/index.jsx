import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import PostList from '../pages/PostList';

// createBrowserRouter() 를 통해 URL 경로와 컴포넌트를 매핑시킬 수 있다.
const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />,
  },
  {
    path: '/posts',
    element: <PostList />,
  },
]);

export default router;

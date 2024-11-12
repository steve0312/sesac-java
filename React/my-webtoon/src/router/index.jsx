import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import WebtoonLayout from '../layouts/WebtoonLayout';
import NovelLayout from '../layouts/NovelLayout';
import RootLayout from '../layouts/RootLayout';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: '/webtoon',
        element: <WebtoonLayout />,
      },
      {
        path: '/novel',
        element: <NovelLayout />,
      },
    ],
  },
]);

export default router;

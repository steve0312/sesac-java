import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import WebtoonLayout from '../layouts/WebtoonLayout';
import NovelLayout from '../layouts/NovelLayout';
import RootLayout from '../layouts/RootLayout';
import WebtoonCategory from '../pages/WebtoonCategory';
import NovelCategory from '../pages/NovelCategory';

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
        children: [
          {
            path: '/webtoon/:dayId',
            element: <WebtoonCategory />,
          },
        ],
      },
      {
        path: '/novel',
        element: <NovelLayout />,
        children: [
          {
            path: '/novel/:genreId',
            element: <NovelCategory />,
          },
        ],
      },
    ],
  },
]);

export default router;

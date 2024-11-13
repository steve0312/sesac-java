import { createBrowserRouter } from 'react-router-dom';
import Home from '../pages/Home';
import WebtoonLayout from '../layouts/WebtoonLayout';
import NovelLayout from '../layouts/NovelLayout';
import RootLayout from '../layouts/RootLayout';
import WebtoonCategory from '../pages/WebtoonCategory';
import NovelCategory from '../pages/NovelCategory';

// 아래의 코드가 문제에서 의도한 코드가 맞다. 어차피 경로를 "/"로 설정하면 되니까 굳이 WebtoonLayout과 NovleLayout의 자식으로 가지는 것보다 최상단으로 뺴면 의도한대로 동작함
// 리팩토링한 코드이고 이전 코드는 아래에 주석처리 해둠
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
            // path: ":dayId",
            path: '/webtoon/:dayId',
            element: <WebtoonCategory />,
            // loader
          },
        ],
      },
      {
        path: '/novel',
        element: <NovelLayout />,
        children: [
          {
            // path: ":genreId",
            path: '/novel/:genreId',
            element: <NovelCategory />,
            // loader
          },
        ],
      },
    ],
  },
]);

export default router;

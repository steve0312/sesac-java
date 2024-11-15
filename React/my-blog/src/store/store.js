import { configureStore } from '@reduxjs/toolkit';
import postsReducer from './slices/postsSlice';

// slice들을 모은 store를 정의
const store = configureStore({
  reducer: {
    posts: postsReducer,
  },
});

export default store;

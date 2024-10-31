/*
강의자료. API 실습
1. TMDB API를 활용하여, 현재 상영 중인 영화 중 평점(vote_average)이 가장 높은 영화를 찾으시오.
*/
import config from '../../../apikey.js';

const TMDB_API = config.TMDB_API_KEY;

async function getMaxVoteAverageMovie() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/now_playing';
    const params = new URLSearchParams({
      api_key: TMDB_API,
      language: 'ko',
    });

    const URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;

    const maxVoteMovie2 = movies.reduce((acc, cur) => {
      const accVoteAverage = acc.vote_average;
      const curVoteAverage = cur.vote_average;

      if (accVoteAverage > curVoteAverage) {
        return acc;
      } else if (accVoteAverage < curVoteAverage) {
        return cur;
      } else {
        // 같을 때
        const accVoteCount = acc.vote_count;
        const curVoteCount = cur.vote_count;
        // 생략
      }
    });
    console.log(maxVoteMovie2.title);
  } catch (error) {
    console.error('Error:', error);
  }
}

getMaxVoteAverageMovie();

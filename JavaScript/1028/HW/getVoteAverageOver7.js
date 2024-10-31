/*
강의자료. API 실습
3. TMDB API를 활용하여, 현재 상영 중인 영화 중 평점(vote_average)이 7 이상인 영화를 나열하시오.
*/

import config from '../../../apikey.js';

const TMDB_API = config.TMDB_API_KEY;

const baseURL = 'https://api.themoviedb.org/3/movie';
const params = new URLSearchParams({
  api_key: TMDB_API,
  language: 'ko',
});

/*
- 현재 상영중인 영화의 목록을 return한다. 
*/
async function getNowPlayingMovies() {
  const path = '/now_playing';

  let URL = `${baseURL}${path}?${params}`;

  const response = await fetch(URL);
  const data = await response.json();

  const movies = data.results;
  return movies;
}

function makeOver7Movies(movies) {
  // 를 담은 array를 만들자.
  const over7Movies = [];

  // 모든 영화에 대해서,
  for (let movie of movies) {
    // 평점이
    const voteAverage = movie.vote_average;

    // 7 이상인 영화
    if (voteAverage >= 7) {
      // 를 담은 array를 만들자.
      over7Movies.push(movie);
    }
  }
  return over7Movies;
}

async function main() {
  // 1. 현재 상영중인 영화를 가져온다.
  const movies = await getNowPlayingMovies();

  const over7Movies = makeOver7Movies(movies);

  const over7Movies2 = movies.filter((movie) => movie.vote_average >= 7);

  console.log(over7Movies);
}

main();

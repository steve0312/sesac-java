import config from '../../apikey.js';

const TMDB_API = config.TMDB_API_KEY;

async function getNowPlayingMovies() {
  try {
    // 현재 상영 중인 영화 데이터 URL 조회
    const baseURL = 'https://api.themoviedb.org/3/movie/now_playing';
    const params = new URLSearchParams({
      api_key: TMDB_API,
    });

    const URL = `${baseURL}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

getNowPlayingMovies();

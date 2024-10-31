import config from '../../apikey.js';

const TMDB_API = config.TMDB_API_KEY;

async function getPopularMovieResults() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie/popular';
    const params = new URLSearchParams({
      api_key: TMDB_API,
    });

    const URL = `${baseURL}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;
    console.log(movies.slice(0, 3));
  } catch (error) {
    console.error('Error:', error);
  }
}

getPopularMovieResults();

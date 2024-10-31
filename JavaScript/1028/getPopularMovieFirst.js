import config from '../../apikey.js';

const TMDB_API = config.TMDB_API_KEY;

async function getPopularMovieFirstTitle() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie/popular';
    const params = new URLSearchParams({
      api_key: TMDB_API,
      language: 'ko',
    });

    const URL = `${baseURL}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;
    const movie = movies[0];
    // console.log(movies.slice(0, 3));
    console.log(movie.title);
  } catch (error) {
    console.error('Error:', error);
  }
}

getPopularMovieFirstTitle();

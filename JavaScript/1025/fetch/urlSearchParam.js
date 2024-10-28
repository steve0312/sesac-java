// UserId=1인 데이터가 조회됨
// 방법1
async function getPost() {
  try {
    const response = await fetch(
      'https://jsonplaceholder.typicode.com/posts?userId=1'
    );

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error: ', error);
  }
}
getPost();

/*
방법2. with query parameter 사용

const baseURL = "https://jsonplaceholder.typicode.com/posts";
const params = new URLSearchParams({
  userId: 1,
});

const URL = `${baseURL}?${params}`;
// 아래 URL과 동일하다.
// https://jsonplaceholder.typicode.com/posts?userId=1

fetch(URL)
  .then((response) => response.json())
  .then((json) => console.log(json))
  .catch((error) => console.error(error));
*/

/*
방법3. with query parameter + async/await 사용

async function getPost() {
  try {
    const baseURL = 'https://jsonplaceholder.typicode.com/posts';
    const params = new URLSearchParams({
      userId: 1,
    });

    const URL = `${baseURL}?${params}`;
    // 아래 URL과 동일하다.
    // https://jsonplaceholder.typicode.com/posts?userId=1

    const response = await fetch(URL);
    const data = await response.json();
    
    console.log(data);
  } catch (error) {
    console.error('Error: ', error);
  }
}
getPost();
*/

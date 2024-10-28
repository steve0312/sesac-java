async function getPostById(postId) {
  const response = await fetch(
    `https://jsonplaceholder.typicode.com/posts/${postId}`
  );
  const data = await response.json(); // json 형식으로 받음
  // const data = await response.text();   // text 형식로 받음
  console.log(data);
}
getPostById(3);

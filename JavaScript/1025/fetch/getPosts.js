async function getPosts() {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts/`);
  const data = await response.json();
  // data.forEach((value) => {
  //   console.log(value.title);
  // });
  const titles = data.map((value) => value.title);
  console.log(titles);

  // console.log(data);
}
getPosts();
/*
과제 12
문제2. 게시글 번호와 제목
- 모든 posts 의 번호 id, 제목 title을 출력한다.
*/

const posts = [
  { id: 1, title: '첫 번째 포스트', content: '첫 번째 포스트 내용' },
  { id: 2, title: '두 번째 포스트', content: '두 번째 포스트 내용' },
  { id: 3, title: '세 번째 포스트', content: '세 번째 포스트 내용' },
];

// forEach 내장 함수를 활용하여 value, index 값을 받아옴
posts.forEach((value, index) => {
  console.log(index + 1, value.title);
});

// 과제 08
/* 문제8. 객체와 배열2
- 위 문제에서 만들어진 변수 `todos` 를 활용한다.
- 배열에 저장된 객체의 키 `content` 와 `isCompleted` 의 값을 출력하는 반복문을 작성한다.
*/
let todos = [];

todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: false,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: false,
  },
];

for (let index in todos) {
  console.log(
    `content: ${todos[index].content}, isCompleted: ${todos[index].isCompleted}`
  );
}

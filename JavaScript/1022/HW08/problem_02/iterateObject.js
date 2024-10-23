// 과제 08
/* 문제9. 객체와 배열3
- 위 문제에서 만들어진 변수 `todos` 를 활용한다.
- 배열에 저장된 객체를 순회하는 반복문을 작성한다.
    - 키 `todoId` 의 값이 `2` 인 객체를 찾아서 출력하는 조건문을 작성한다.
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
  if (todos[index].todoId === 2) console.log(todos[index]);
}
/* 과제 10
문제6. 배열 내 객체 출력하기1
- 아래 객체를 저장한 배열을 생성하고, 변수 todos 에 할당한다.
{
  "todoId": 1,
  "content": "예습하기",
  "isCompleted": false
},
{
  "todoId": 2,
  "content": "강의듣기",
  "isCompleted": false
},
{
  "todoId": 3,
  "content": "복습하기",
  "isCompleted": false
}
- 적절한 배열 함수를 선택해서 배열 내 객체를 하나씩 출력한다
*/
let todos = [
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

todos.forEach((object) => console.log(object));

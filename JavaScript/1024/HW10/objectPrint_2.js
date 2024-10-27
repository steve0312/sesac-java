/* 과제 10
// 문제7. 배열 내 객체 출력하기2
- 아래 객체를 저장한 배열을 생성하고, 변수 todos 에 할당한다.
{
  "todoId": 1,
  "content": "예습하기",
  "isCompleted": false
},
{
  "todoId": 2,
  "content": "강의듣기",
  "isCompleted": true
},
{
  "todoId": 3,
  "content": "복습하기",
  "isCompleted": true
}
- 적절한 배열 함수를 선택해서 배열 내 객체 중 isCompleted 가 true 인 객체만 출력한다.
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
    isCompleted: true,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: true,
  },
];

todos.filter((object) => {
  if (object.isCompleted === true) console.log(object);
});

/*
// for~in 반복문 사용하는 방법
for (let index in todos) {
  if (todos[index].isCompleted === true) {
    console.log(todos[index]);
  }
}
*/

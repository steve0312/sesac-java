// 강의자료 : JavaScript 제어문 실습2
/* 문제8. 
- 주어진 테이블의 데이터를 "people" 변수에 저장하시오.
- 사람에 대한 정보를 각각 출력하시오(형식은 자유롭게)
- 이름이 alex인 사람에 대한 정보를 출력하시오
- 이름이 alex인 사람의 나이를 출력하시오
- 이름을 활용하여 각 사람의 데이터에 쉽게 접근할 수 있도록 people 변수를 수정하시오.
*/
let person = [
  { name: 'jun', age: 15, gender: 'M' },
  { name: 'ken', age: 26, gender: 'F' },
  { name: 'alex', age: 37, gender: '-' },
];

console.log(person[0]['name']);
console.log(person[2]);
console.log(person[2]['age']);

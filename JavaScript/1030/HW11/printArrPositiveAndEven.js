/*
과제11
문제4. 새로운 배열
- 변수 arr 을 선언하고, 아래 배열을 할당한다.
- 배열의 원소 중 양수이면서 짝수인 원소만 모아서 새로운 배열을 만들어서 출력한다.
*/

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 방법1. filter 함수 사용
const new_arr = arr.filter((el) => {
  return el > 0 && el % 2 === 0;
});

console.log(new_arr);

/* 
방법2. 반복문 / 조건문 사용
const new_arr = [];
for (let el of arr) {
  if (el > 0 && el % 2 === 0) {
    new_arr.push(el);
  }
}

console.log(new_arr);
*/

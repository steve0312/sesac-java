/*
과제11
문제7. X보다 큰 값
- 변수 `x` 를 선언하고, 임의의 숫자값을 할당한다.
- 변수 `x` 를 출력한다.
- 변수 `arr` 을 선언하고, 아래 배열을 할당한다.
- 배열의 원소 중 변수 x 보다 큰 원소만 모아서 새로운 배열 을 만들어서 출력한다.
*/

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];
let x = 5;

const overX = arr.filter((el) => {
  return el > x;
});

console.log(x);
console.log(overX);
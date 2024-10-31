/*
과제11
문제5. 배열 원소의 곱
- 변수 arr 을 선언하고, 아래 배열을 할당한다.
- 배열의 모든 원소를 곱한 값을 출력한다.
*/

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 방법1. 반복문 사용
let allMultiple = 1;

for (let el of arr) {
  allMultiple *= el;
}

console.log(allMultiple);

/*
방법2. reduce 함수 사용
const product = arr.reduce((acc, num) => acc * num, 1);
console.log(product);
*/

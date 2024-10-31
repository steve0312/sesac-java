/*
과제11
문제6. 마지막 홀수
- 변수 arr 을 선언하고, 아래 배열을 할당한다.
- 배열의 원소 중 마지막으로 나온 홀수의 값을 출력한다.
*/

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

let count = 1;

for (let el of arr) {
  count++;

  if (el % 2 !== 0 && count === arr.length) {
    console.log(el);
  }
}

/*
방법2. 배열을 뒤집어서 홀수의 값 출력
let lastOdd;

for (const el of arr.reverse()) {
  if (el % 2 !== 0) {
    lastOdd = el;
    break;
  }
}

console.log(lastOdd);
*/

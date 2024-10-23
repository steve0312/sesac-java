// 강의자료 : JavaScript 제어문 실습2
// 문제5. 두 개의 숫자에 대해, 두 수 사이에 속한 모든 정수의 합을 구하시오. (ex. 2와 5를 입력받는다면 2 + 3 + 4 + 5 = 14)
let num1 = 2;
let num2 = 5;
let sum = 0;

for (num1; num1 <= num2; num1++) {
  sum += num1;
}

console.log('sum : ', sum);

/*
// 방법2
// a의 값을 임시로 저장
let tmp = a;
// b의 값을 a에 넣고
a = b;
// b에 a의 예전 값을 넣습니다.
b = tmp;

console.log(a, b);

let num1 = 5;

let num2 = 2;

if (num1 > num2) {
  let tmp = num1;
  num1 = num2;
  num2 = tmp;
}

let total = 0;
for (let num = num1; num <= num2; num++) {
  total += num;
}

console.log(total);
*/

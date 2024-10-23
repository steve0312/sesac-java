// 강의자료 : JavaScript 제어문 실습2
// 문제1. 40 이하의 3의 배수를 출력하시오.
let index = 0;
let num = 1;

while (true) {
  if (3 * num > 40) {
    break;
  }
  console.log(`3 * ${num} = ${num * 3}`);

  num++;
}
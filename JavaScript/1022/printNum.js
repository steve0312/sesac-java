// 강의자료 : JavaScript 제어문 실습2
// 문제6. 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력하시오.
const array_multiple = [];

for (let num = 1; num <= 30; num++) {
  if (num % 2 === 0 || num % 3 === 0) continue;

  // console.log(num);
  array_multiple.push(num);
}

console.log(array_multiple);
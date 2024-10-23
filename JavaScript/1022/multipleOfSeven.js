// 강의자료 : JavaScript 제어문 실습2
// 문제2. 1~100 중에 7의 배수의 개수를 출력하세요.
let num = 1;
let count_num = [];

while (num <= 100) {
  if (num % 7 === 0) {
    count_num.push(num);
  }
  num++;
}

console.log(`7의 배수의 개수 : ${count_num.length}`);

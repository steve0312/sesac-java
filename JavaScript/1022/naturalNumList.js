// 강의자료 : JavaScript 제어문 실습2
// 문제4. 1~9까지의 자연수 중 제곱한 수가 10 이상 50 이하인 자연수의 리스트를 출력해보세요.
const answer = [];

for (let num = 1; num < 10; num++) {
  let square = num ** 2;

  if (square >= 10 && square <= 50) {
    answer.push(num);
  }
}

console.log(answer);

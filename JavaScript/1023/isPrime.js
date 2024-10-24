/*
강의자료 : JavaScript 함수
실습 문제2. 소수를 판별하는 함수 만들기
*/

function isPrime(num) {
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      return false;
    }

    return true;
  }
}
console.log(isPrime(11));
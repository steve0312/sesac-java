// 강의자료 : JavaScript 제어문 실습2
// 문제7. 자연수 n이 주어졌을 때, n이 소수인지 판단하시오.
let num = 17;
// 소수인지 확인하기 위해 변수 설정
let isPrime = true;

// 소수는 1과 자기 자신으로는 무조건 나눠떨어지므로 1과 자기 자신(num)을 제외한 범위로 설정
for (let i = 2; i < num; i++) {
	// 1과 자기 자신이 아닌 다른 수(i)로도 나눠 떨어지므로 소수가 아님)
  if (num % i === 0) {
    isPrime = false;
  }
}
console.log(isPrime);
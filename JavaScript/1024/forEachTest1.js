const numbers = [1, 2, 3, 4];

console.log('일반적인 사용법');

numbers.forEach((num) => {
  console.log(num); // 1, 2, 3, 4
});
console.log();

console.log('위의 코드를 분해한 코드');

const console_log = (num) => {
  console.log(num);
};

numbers.forEach(console_log);
console.log();

console.log('아래 코드와 같은 의미.');
console.log(
  'array에서 직접 실행 가능한 메서드 => array를 입력 받는 함수로 변경된 코드'
);
function myForEach(arr, func) {
  for (let value of arr) {
    func(value);
  }
}

myForEach([1, 2, 3, 4], console_log);

console.log('콜백함수의 function자리 input값으로 call이 들어가면 안됨');
// numbers.forEach();
// console_log() // 괄호가 있으면 함수의 결과값을 넘기는 것

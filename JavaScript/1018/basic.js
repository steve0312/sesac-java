let x1 = 10;
let x2 = '10';
let result = x1 % 2 === 0 ? '짝수' : '홀수';

console.log(`${x1}는 ${result}입니다!`);

console.log(0 / 0);
console.log(1 / 0);
console.log(2 ** 3);

if (x1 === x2) {
  console.log(`${x1} 과 ${x2} 는 완전 동일`);
} else {
  console.log(`${x1} 과 ${x2} 는 부분 동일`);
}

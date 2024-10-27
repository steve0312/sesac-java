//minValue를 reduce를 통해 계산하기
const numbers = [5, 8, 2, 5, 9, 4];

const minValue = numbers.reduce((acc, cur) => {
  if (acc > cur) acc = cur;

  return acc;
}, Infinity);

console.log(minValue);

/*
// 삼항연산자를 활용한 방법
const numbers = [5, 8, 2, 5, 9, 4];

const minValue = numbers.reduce((acc, cur) => {
  return acc > cur ? cur : acc;
}, Infinity);

console.log(minValue);
*/
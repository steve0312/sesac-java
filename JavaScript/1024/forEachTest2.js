// 배열 요소의 값, 인덱스, 배열 형태로도 값을 뽑아낼 수 있음
const arr = ['a', 'b', 'c', 'd'];

arr.forEach((value, index, arr) => {
  console.log(value, index, arr);
});

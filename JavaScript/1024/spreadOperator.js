let arr_1 = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];
let arr_2 = arr_1;
let arr_3 = [...arr_1]; // 얕은 복사가 진행됨

arr_1[1][1] = 100;

console.log(arr_1); // 값이 바뀜
console.log(arr_2); // 값이 바뀜
console.log(arr_3); // 값이 바뀜

arr_1[1] = 100;

console.log(arr_1); // 값이 바뀜
console.log(arr_2); // 값이 바뀜
console.log(arr_3); // 값이 안 바뀜

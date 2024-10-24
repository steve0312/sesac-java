/* 
강의자료 : JavaScript 제어문 실습2
문제 9-2번
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
모든 원소들의 합을 구하시오
ex. 1 + 2 + 3 + 4 ... + 9
*/
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

let sum = 0;

for (let i in nums) {
  let arr = nums[i];

  for (let j in arr) {
    sum += nums[i][j];
  }
}

console.log(sum);

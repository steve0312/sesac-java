/* 
강의자료 : JavaScript 제어문 실습2
문제 9-3번
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
열들의 합의 값으로 리스트를 만드세요
ex. [1 + 4 + 7, 2 + 5 + 8, 3 + 6 + 9]
*/
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

let list = [];

for (let i in nums) {
  let sum = 0;
  let arr = nums[i];

  for (let j in arr) {
    sum += nums[j][i];
  }
  list.push(sum);
}
console.log(list);
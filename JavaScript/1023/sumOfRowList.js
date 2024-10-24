/* 
강의자료 : JavaScript 제어문 실습2
문제 9-1번
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
행들의 합의 값으로 리스트를 만드세요
ex. [6, 15, 24]. 즉,  [1 + 2 + 3,  4 + 5 + 6, 7 + 8 + 9]
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
    sum += arr[j];
  }
  list.push(sum);
}
console.log(list);

/* 방법2
let result = [];

for (let arr of nums) {
  let sum = 0;
  for (let num of arr) {
    sum += num;
  }
  result.push(sum);
}
console.log(result);
*/

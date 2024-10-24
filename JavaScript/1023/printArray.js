/* 
강의자료 : JavaScript 제어문 실습2
문제 9-0번
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
1 ~ 9 순서대로 출력해보자.
*/
const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

/* 방법1: for~of 사용
for (let arr of nums) {
  for (let num of arr) {
    console.log(num);
  }
}
*/

/* 방법2: for~in 사용
for (let i in nums) {
  let arr = nums[i];
  for (let j in arr) {
    let num = arr[j];

    console.log(num);
  }
}
*/

// 방법3: 기본 for문 사용
for (let i = 0; i < nums.length; i++) {
  for (let j = 0; j < nums[i].length; j++) {
    console.log(nums[i][j]);
  }
}

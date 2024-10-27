/* 과제 10
// 문제9. 이차원 배열의 합
- 아래 이차원 배열을 생성하고, 변수 matrix 에 할당한다.
[[4,2], [3,2], [5,7], [10,1]]

- 적절한 배열 함수를 선택해서 내부 배열의 원소 합이 짝수인 배열만 모아서 새로운 이차원 배열을 생성한다.
- 새로운 이차원 배열을 출력한다.
*/

//
let matrix = [
  [4, 2],
  [3, 2],
  [5, 7],
  [10, 1],
];
let new_matrix = [];

matrix.forEach((nums) => {
  let sum = 0;

  for (let num of nums) {
    sum += num;
  }

  if (sum % 2 === 0) {
    new_matrix.push(nums);
  }
});

console.log(new_matrix);

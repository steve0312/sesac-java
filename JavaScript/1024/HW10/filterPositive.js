// 과제 10
// 문제4. 양수 홀수 배열
// - 첫 문제에서 만들어진 변수 `arr` 을 활용한다.
// - 배열 함수 `filter()` 를 활용하여 양수이면서 홀수인 원소만 모은 새로운 배열을 만들고 출력한다.

let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

const filter_positive = arr.filter((num) => {
  return num > 0 && num % 2 !== 0;
});

console.log(filter_positive);

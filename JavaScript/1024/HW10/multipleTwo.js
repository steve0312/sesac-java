// 과제 10
// 문제3. 곱하기 2
// - 첫 문제에서 만들어진 변수 `arr` 을 활용한다.
// - 배열 함수 `map()` 를 활용하여 각 원소에 곱하기 2를 한 값을 모은 새로운 배열을 만들고 출력한다.

let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

const multiple_two = arr.map((num) => {
  return num * 2;
});

console.log(multiple_two);

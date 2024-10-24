/*
과제 09
문제5. 가장 작은 값
- 배열에서 가장 작은 값을 찾는 함수 `minNumber` 를 정의한다.
- 임의의 변수를 선언하고, 숫자형 값을 저장한 배열을 생성하고 할당한다
- 변수를 출력한다.함수 `minNumber` 를 호출해서 배열에서 가장 작은 수를 구하고, 출력한다.
*/

const array = [10, 25, 36, 99, 58];

function minNumber(arr) {
  let min = Infinity;

  for (let num of arr) {
    if (num < min) min = num;
  }

  return min;
}
console.log(array);
console.log(minNumber(array));

/*
과제 09
문제4. 가장 큰 값
- 배열에서 가장 큰 값을 찾는 함수 `maxNumber` 를 정의한다.
    - 1개의 매개변수 `arr` 를 입력 받는다.
    - 가장 큰 값을 저장할 변수 `max` 를 선언하고, `-Infinity` 를 할당한다.
    - 변수 `arr` 를 순회하는 반복문을 작성한다.
        - 원소가 `max` 보다 크면 `max` 를 갱신한다.
    - 변수 `max` 를 반환한다.
- 임의의 변수를 선언하고 숫자형 값 5개를 저장한 배열을 생성해서 할당한다.
- 변수를 출력한다.
- 함수 `maxNumber` 를 호출해서 배열에서 가장 큰 수를 구하고, 출력한다.
*/

const array = [10, 25, 36, 99, 58];

function maxNumber(arr) {
  let max = -Infinity;

  for (let num of arr) {
    if (num > max) max = num;
  }

  return max;
}
console.log(array);
console.log(maxNumber(array));
/*
과제 09
문제6. 짝수
- 배열에서 짝수인 값을 찾는 함수 `evenNumber` 를 정의한다.
    - 1개의 매개변수 `arr` 를 입력 받는다.
    - 변수 `new_arr` 를 선언하고, 빈 배열을 할당한다.
    - 변수 `arr` 를 순회하는 반복문을 작성한다.
        - 원소가 짝수면 변수 `new_arr` 에 추가한다.
    - 변수 `new_arr` 를 반환한다.
- 임의의 변수를 선언하고 숫자형 값 5개를 저장한 배열을 생성해서 할당한다.
- 변수를 출력한다.
- 함수 `evenNumber` 를 호출해서 짝수만 저장된 배열을 구하고, 출력한다.
*/

const array = [10, 25, 36, 99, 58];

let new_arr = [];

function evenNumber(arr) {
  for (let num of arr) {
    if (num % 2 === 0) new_arr.push(num);
  }

  return new_arr;
}
console.log(array);
console.log(evenNumber(array));

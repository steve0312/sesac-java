/*
과제 09
문제2. 크기 비교 함수
- 아래와 같은 기능을 수행하는 함수 `compare` 를 정의한다.
    - 2개의 매개변수 `x1` `x2` 를 입력 받는다.
    - `x1` 과 `x2` 의 크기를 비교하는 조건문을 작성한다.
        - 두 변수 중 더 큰 변수를 반환한다.
        - 더 변수가 같다면 `null` 을 반환하다.
- 임의의 변수 2개를 선언하고, 숫자형 값을 할당한다.
- 2개의 변수를 출력한다.
- 함수 `compare` 를 호출해서 두 변수 중 더 큰 값을 구하고, 출력한다.
*/

function compare(x1, x2) {
  if (x1 > x2) {
    return x1;
  } else if (x1 < x2) {
    return x2;
  } else if (x1 === x2) {
    return null;
  }
}
let x3 = 2;
let x4 = 2;
console.log(x3, x4);
console.log(compare(x3, x4));
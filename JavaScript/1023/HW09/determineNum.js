/*
과제 09
문제3. 양수, 음수, 0
- 아래와 같은 기능을 수행하는 함수 `determine` 를 정의한다.
    - 1개의 매개변수 `x` 를 입력 받는다.
    - `x` 가 어떤 수 인지 판별하는 조건문을 작성한다.
        - 양수라면 `1` 을 반환한다.
        - 음수라면 `-1` 을 반환한다.
        - 0이라면 `0` 을 반환한다.
- 임의의 변수를 선언하고, 숫자형 값을 할당한다.
- 변수를 출력한다.
- 함수 `determine` 를 호출해서 변수가 어떤 수 인지 구하고, 출력한다.
*/

function determine(x) {
  if (x > 0) {
    return 1;
  } else if (x < 0) {
    return -1;
  } else {
    return 0;
  }
}
let x5 = 10;
console.log(x5);
console.log(determine(x5));

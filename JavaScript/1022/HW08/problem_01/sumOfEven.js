// 과제 08
/* 문제4. 짝수의 합
- 변수 `N` 을 선언하고, 임의의 숫자형 값을 할당한다.
- 변수 `total` 을 선언하고, `0` 을 할당한다.
- 변수 `N` 의 값을 출력한다.
- 1부터 `N` 까지의 숫자 중 짝수만 변수 `total` 에 더하는 반복문을 작성한다.
- 변수 `total` 의 값을 출력한다.
*/
let n = 5;
let total_new = 0;

console.log(n);
console.log();

for (let index = 1; index <= n; index++) {
  if (index % 2 === 0) {
    total_new += index;
  }
}
console.log(total_new);
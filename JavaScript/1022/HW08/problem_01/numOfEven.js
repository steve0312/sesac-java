// 과제 08
/* 문제5. 짝수의 개수
- 변수 `N` 을 선언하고, 임의의 숫자형 값을 할당한다.
- 1부터 `N` 까지의 숫자 중 짝수의 개수를 구하는 반복문을 작성한다.
- 짝수의 개수를 출력한다.
*/
let n = 5;
let count_new = 0;

console.log(n);
console.log();

for (let index = 1; index <= n; index++) {
  if (index % 2 === 0) count_new++;
}
console.log(count_new);
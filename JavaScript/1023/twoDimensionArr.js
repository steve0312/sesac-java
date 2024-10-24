/* 
강의자료 : JavaScript 제어문 실습2
문제 10번
구구단이 들어있는 2차원 배열을 만드시오. n*m 단이 들어있는 2차원 배열을 만드시오.
ex. 3*4단
1 2 3 4
2 4 6 8
3 6 9 12
*/

/*
구현 순서
1. 전체를 담을 수 있는 container 생성
2. 1단 생성
3. 1단을 1번에 넣는다.
4. 2단 생성
5. 2단을 1번에 넣는다.
6. 위의 과정 반복
*/
const gugudan = [];
let n_dan;
let a = 19;
let b = 19;

for (let n = 1; n <= a; n++) {
  n_dan = [];
  for (let i = 1; i <= b; i++) {
    n_dan.push(n * i);
  }
  gugudan.push(n_dan);
}
console.log(gugudan);

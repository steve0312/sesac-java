/*
강의자료 : JavaScript 함수
실습 문제3. 구구단 중 n단을 return 하는 함수 만들기
*/

function makeNdan(n) {
  let ndan_list = [];

  for (let i = 1; i <= 9; i++) {
    ndan_list.push(n * i);
  }

  return ndan_list;
}
console.log(makeNdan(5));
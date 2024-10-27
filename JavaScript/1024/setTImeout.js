console.log('A');

setTimeout(() => {
  console.log('B'); // 함수 실행 후 1초 후에 실행된다.
}, 1000);

console.log('C');

/*
A
C
B
*/

/*
// setTimeout()이 기다렸다가 실행한다는 개념이라서 0초로 설정해도 C가 먼저 실행되고나서 B가 실행됨
console.log('A');

setTimeout(() => {
    console.log('B'); // 함수 실행 후 0 후에 실행된다.
}, 0);

console.log('C');
*/

/*
A
C
B
*/

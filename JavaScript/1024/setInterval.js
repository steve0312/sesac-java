let number = 0;

setInterval(() => {
  // 1초마다 아래 코드가 실행된다.
  console.log(number);
  number = number + 1;
}, 1000);

console.log('Hello World');

/*
Hello World
0
1
2
3
... 
*/

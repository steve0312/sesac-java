/*
과제11
문제3. 양수 출력
- 변수 arr 을 선언하고, 아래 배열을 할당한다.
- 배열의 원소 중 양수만 출력한다.
*/

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 방법1. for ~ of 사용
for (let el of arr) {
  if (el > 0) {
    console.log(el);
  }
}

/* 
방법2. filter 함수 사용
const num = arr.filter((el) => {
  return el > 0;
});

console.log(num);
*/

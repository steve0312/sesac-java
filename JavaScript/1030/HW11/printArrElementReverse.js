/*
과제11
문제2. 배열 원소 거꾸로 출력
- 변수 arr 을 선언하고, 아래 배열을 할당한다.
- 배열의 원소를 거꾸로 출력한다.
*/
const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];

// 방법1
for (let index = arr.length - 1; index >= 0; index--) {
  console.log(arr[index]);
}

/* 
방법2
for (let el of arr.reverse()) {
  console.log(el);
}
*/

// 과제 08
/* 문제6. 반복문 제어
- 아래와 같은 배열이 있을 때 배열의 원소를 출력하는 반복문을 작성한다.
    - 원소가 짝수라면 원소를 출력하지 않고, 반복문을 즉시 종료한다.
    arr = [1, 9, 3, 11, 4, 5, 2, 7]
*/
let arr = [1, 9, 3, 11, 4, 5, 2, 7];

for (let index in arr) {
  if (arr[index] % 2 === 0) break;

  console.log(arr[index]);
}
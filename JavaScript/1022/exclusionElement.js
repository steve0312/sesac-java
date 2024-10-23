// 강의자료 : JavaScript 제어문 실습2
// 문제3. const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7] 일 때, 원소가 1, 4, 5, 7인 경우를 제외하고 출력하세요.
const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];

// 방법1
for (let num of arr) {
  if (num === 1 || num === 4 || num === 5 || num === 7) continue;

  console.log(num);
}

// 방법2 (Set 활용)
// const notLogSet = new Set([1, 4, 5, 7]);

// for (let num of arr) {
//   if (notLogSet.has(num)) continue;

//   console.log(num);
// }

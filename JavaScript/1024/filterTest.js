// filter를 가지고 소수만 모아보기
const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];

const prime = nums.filter((num) => {
  for (let index = 2; index < num; index++) {
    return num % index !== 0;
  }
});

console.log(prime);

// 강사님 코드

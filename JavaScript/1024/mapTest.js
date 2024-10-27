// strNumbers -> numNumbers로 바꾸어 새로운 변수에 할당하여라.
// const numNumbers = [1, 2, 3, 4];
const strNumbers = ['1', '2', '3', '4'];
const toInt = strNumbers.map((char) => {
  return parseInt(char);
  // parseInt(char);     // return 키워드를 생략하고 parseInt()만 써도 사용 가능
});

console.log(strNumbers);  // 문자열 '1', '2', '3', '4'로 표현된 배열
console.log(toInt); // 숫자 1, 2, 3, 4로 표현된 배열

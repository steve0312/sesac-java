let condition = 101;

if (condition >= 0 && condition <= 50) {
  console.log("미세먼지가 '좋음' 입니다.");
} else if (condition > 50 && condition <= 100) {
  console.log("미세먼지가 '보통' 입니다.");
} else if (condition > 100 && condition <= 250) {
  console.log("미세먼지가 '나쁨' 입니다.");
} else if (condition > 250 && condition <= 500) {
  console.log("미세먼지가 '매우 나쁨' 입니다.");
} else {
  console.log('미세먼지 표현방법으로 표현되지 않는 지수입니다.');
}

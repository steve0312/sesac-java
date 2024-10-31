/* 
과정
1. 개발자 도구에서 inspector를 통해 바꾸려는 이미지를 클릭
2. 이미지 태그 부분을 우클릭해서 Copy -> Copy JS Path 를 클릭해서 이미지 주소 복사하기
3. 변수에 복사한 이미지 주소를 할당
4. 새로 넣어줄 이미지의 주소를 복사
5. 변수에 src 속성에 새로 넣어줄 이미지의 주소를 대입
6. 이미지가 변경되었음을 확인
*/

const tag = document.querySelector(
  '#container > div.HomeView__daily_section--bBwGG > div.DailyList__flicking_wrap--g2el0 > div.flicking-viewport > div > ul > li:nth-child(1) > a > div > img'
);
tag.src = 'https://cdn.mhns.co.kr/news/photo/202409/618552_757898_619.jpg';

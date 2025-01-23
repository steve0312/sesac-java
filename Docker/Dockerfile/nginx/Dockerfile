# 이미지 지정
FROM nginx:stable

# 포트 명시
EXPOSE 80

# index.html 파일을 컨테이너의 /usr/share/nginx/html/ 에 복사
COPY ./index.html /usr/share/nginx/html/

# nginx 를 실행
CMD ["nginx", "-g", "daemon off;"]
# 베이스 이미지 지정
FROM node:lts

# 컨테이너는 처음 기본 작업 디렉토리가 root이다.
# 근데 WORKDIR 를 사용하면 작업 디렉토리를 변경해줄 수 있다.
# 이후에 CMD 명령어로 실행되는 작업들은 변경한 작업 디렉토리에서 실행됨
WORKDIR /app

# 현재 위치의 package.json 파일을 현재 작업 디렉토리(./)로 복사 
COPY ./package.json ./

# 이미지를 빌드하는 동안 실행될 명령어 정의
# 명령어 실행 결과들은 이미지에 적용
RUN npm install
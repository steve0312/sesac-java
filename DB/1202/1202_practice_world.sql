-- Active: 1732689679694@@127.0.0.1@3306@world
-- 평균 인구수보다 인구가 많은 도시들 조회
SELECT c.`Name` 
FROM city c
WHERE c.`Population` > 10000;

SELECT AVG(c.`Population`) 
FROM city c;

-- 서브쿼리화
SELECT c.`Name` 
FROM city c
WHERE c.`Population` > (
  SELECT AVG(c.`Population`) 
  FROM city c
);


-- 가장 많은 인구를 가진 도시의 국가 정보
-- 어떤 국가의 정보를 조회
SELECT co.`Name`
FROM country co
WHERE 조건

-- 가장 많은 인구를 가진 도시를 조회
SELECT * 
FROM city ci
ORDER BY ci.`Population` DESC
LIMIT 1;

-- 가장 많은 인구를 가진 도시의 국가코드 조회
SELECT ci.`CountryCode`
FROM city ci
ORDER BY ci.`Population` DESC
LIMIT 1;


-- Subquery 적용 후
SELECT co.`Name`
FROM country co
WHERE co.`Code` = (
  SELECT ci.`CountryCode`
  FROM city ci
  ORDER BY ci.`Population` DESC
  LIMIT 1
);


-- 인구 500만 이상인 도시가 있는 국가 찾기
-- 국가에 대한 정보 조회
SELECT * 
FROM country co;

-- 인구가 500만 이상인 도시 조회
SELECT * 
FROM city ci
WHERE ci.`Population` >= 5000000;


-- Subquery 적용 후
SELECT co.`Name`
FROM country co
WHERE co.`Code` IN (
  SELECT ci.`CountryCode` 
  FROM city ci
  WHERE ci.`Population` >= 5000000
);

-- 위의 코드를 JOIN으로 전환 (결과는 동일)
SELECT DISTINCT co.`Name`
FROM country co
JOIN city ci ON co.`Code` = ci.`CountryCode`
WHERE ci.`Population` >= 5000000;
-- Active: 1732689679694@@127.0.0.1@3306@world

-- 1. 도시의 입장에서 도시가 속한 국가와 대륙을 조회
SELECT city.Name as CityName, 
       country.Name as CountryName,
       country.Continent
FROM city
INNER JOIN country ON city.CountryCode = country.Code

-- 2. 국가의 입장에서 국가가 가지고 있는 도시를 함께 조회
SELECT co.`Name`, ci.`Name`, co.`Continent` FROM country co
INNER JOIN city ci ON co.`Code` = ci.`CountryCode`;
-- ORDER BY co.`Name`;

-- 한국의 도시 이름을 오름차순으로 조회
SELECT co.`Name`, ci.`Name` FROM country co
INNER JOIN city ci ON co.`Code` = ci.`CountryCode`
WHERE co.`Code` = 'KOR'
ORDER BY ci.`Name`;


-- 모든 국가와 수도 정보
-- 국가 입장에서 수도 조회
-- => 국가별 수도를 파악할 때 사용
SELECT country.Name as CountryName, 
       city.Name as CapitalCity
FROM country
LEFT JOIN city ON country.Capital = city.ID;

-- 도시 입장에서 수도 조회
-- => 도시가 수도인지 파악하고 싶을 때 사용
SELECT ci.`Name` `도시명`, co.`Name` `국가명` FROM city ci
LEFT JOIN country co ON ci.`ID` = co.`Capital`;

SELECT country.Name as CountryName, 
       city.Name as CapitalCity
FROM country
LEFT JOIN city ON country.Capital = city.ID
WHERE city.Name IS NULL;
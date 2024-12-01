-- Active: 1732689679694@@127.0.0.1@3306@world


-- country에 있는 모든 필드 조회
SELECT * FROM country;

-- 동일한 결과
SELECT Name, Population FROM country;
SELECT `Name`, `Population` FROM country;

SELECT country.`Name`, country.`Population` FROM country;

SELECT c.`Name`, c.`Population` FROM country c;

SELECT c.`Name` AS 국가명, c.`Population` AS 인구수 FROM country c;
SELECT c.`Name` 국가명, c.`Population` 인구수 FROM country  AS c;

SELECT DISTINCT c.`Continent`, c.`Region` FROM country c;

SELECT `Name`, `Population` FROM country
WHERE `Population` > 1000000;

-- name이 s로 시작하는 국가 중 인구가 1000000 이상인 나라 선택
SELECT `Name` FROM country
WHERE `Population` > 1000000 
AND `Name` LIKE 's%';

-- BINARY : 대소문자 구분
SELECT `Name` FROM country
WHERE `Population` > 1000000 
AND `Name` LIKE BINARY 'S%';


-- WHERE
-- 실습
-- 인구가 800만 이상인 도시의 Name, Population을 조회하시오
SELECT c.`Name`, c.`Population` FROM city c
WHERE c.`Population` >= 8000000;

-- 한국(KOR)에 있는 도시의 Name, CountryCode를 조회하시오
SELECT c.`Name`, c.`CountryCode` FROM city c
WHERE c.`CountryCode` = 'KOR';

-- 이름이 'San'으로 시작하는 도시의 Name을 조회하시오
SELECT c.`Name` FROM city c
WHERE c.`Name` LIKE 'San%';

-- 이름이 'San '으로 시작하는 도시의 Name을 조회하시오
-- 띄어쓰기가 포함돼서 san miguel 같은 이름들이 조회됨
SELECT c.`Name` FROM city c
WHERE c.`Name` LIKE 'San %';

-- 인구가 100만에서 200만 사이인 한국 도시의 Name을 조회하시오
SELECT c.`Name`, c.`Population`, c.`CountryCode` FROM city c
WHERE c.`Population` BETWEEN 1000000 AND 2000000
  AND c.`CountryCode` = 'KOR';

-- 인구가 500만 이상인 한국, 일본, 중국의 도시의 Name, CountryCode, Population 을 조회하시오
SELECT c.`Name`, c.`CountryCode`, c.`Population` FROM city c
WHERE c.`Population` >= 5000000
  AND c.`CountryCode` IN ('KOR', 'JPN', 'CHN');

-- 오세아니아 대륙에서 예상 수명의 데이터가 없는 나라의 Name, LifeExpectancy, Continent를 조회하시오.
SELECT c.`Name`, c.`LifeExpectancy`, c.`Continent` FROM country c
WHERE c.`Continent` = 'Oceania'
  AND c.`LifeExpectancy` IS NULL;


-- GROUP BY
-- 실습
-- 대륙별 총 인구수를 구하시오.
SELECT c.`Continent`, SUM(c.`Population`) AS total_population FROM country c
GROUP BY c.`Continent`;

-- Region별로 가장 높은 GNP를 찾으시오
SELECT c.`Region`, MAX(c.`GNP`) AS max_GNP FROM country c
GROUP BY c.`Region`;

-- 대륙별 평균 GNP와 평균 인구를 구하시오
SELECT c.`Continent`, AVG(c.`GNP`) AS avg_GNP, AVG(c.`Population`) As avg_Population FROM country c
GROUP BY c.`Continent`;

-- 인구가 50만에서 100만 사이인 도시들에 대해, District별 도시 수를 구하시오
SELECT c.`District`, COUNT(*) AS count_city FROM city c
WHERE c.`Population` BETWEEN 500000 AND 1000000
GROUP BY c.`District`;

-- 아시아 대륙 국가들의 Region별 총 GNP를 구하세요
SELECT c.`Region`, SUM(c.`GNP`) AS sum_GNP FROM country c
WHERE c.`Continent` = 'Asia'
GROUP BY c.`Region`;


-- HAVING
-- 실습
SELECT c.`Continent`, COUNT(*) AS cont_country_count FROM country c
GROUP BY c.`Continent`;

SELECT c.`Continent`, COUNT(*) AS cont_country_count FROM country c
GROUP BY c.`Continent`
HAVING cont_country_count > 20;

SELECT c.`Continent`, COUNT(*) AS country_count FROM country c
WHERE c.`Population` > 10000000
GROUP BY c.`Continent`
HAVING country_count > 10;

SELECT c.`Continent`, COUNT(*) AS country_count FROM country c
GROUP BY c.`Continent`
HAVING AVG(c.`Population`) > 10000000;


-- 실습
-- 각 국가별 도시가 10개 이상인 국가의 CountryCode, 도시 수를 조회하시오.
SELECT c.`CountryCode`, COUNT(*) FROM city c
GROUP BY c.`CountryCode`
HAVING COUNT(*) >= 10;

-- District별 평균 인구가 100만 이상이면서 도시 수가 3개 이상인 District,  도시 수, 총 인구를 구하시오
SELECT c.`District`, SUM(c.`Population`) 총_인구_수, COUNT(*) 도시_수 FROM city c
GROUP BY c.`District`
HAVING AVG(c.`Population`) >= 1000000 AND COUNT(*) >= 3;

-- 아시아 대륙의 국가들 중에서, Region별 평균 GNP가 1000 이상인 Region,  평균 GNP를 조회하시오
SELECT c.`Region`, AVG(c.`GNP`) AS region_avg_GNP FROM country c
WHERE c.`Continent` = 'Asia'
GROUP BY c.`Region`
HAVING region_avg_GNP >= 1000;

-- 독립년도가 1900년 이후인 국가들 중에서, 대륙별 평균 기대수명이 70세 이상인 Continent, 평균 기대수명을 조회하시오.
SELECT c.`Continent`, AVG(c.`LifeExpectancy`) AS avg_LifeExpectancy FROM country c
WHERE c.`IndepYear` > 1900
GROUP BY c.`Continent`
HAVING avg_LifeExpectancy >= 70;

-- CountryCode별 도시 평균 인구가 100만 이상이고 도시 최소 인구가 50만 이상인 CountryCode, 총 도시수, 총 인구수를 조회하시오.
SELECT c.`CountryCode`, SUM(c.`Population`) `총 인구 수`, COUNT(*) AS `총 도시 수` FROM city c
GROUP BY c.`CountryCode`
HAVING AVG(c.`Population`) >= 1000000 AND MIN(c.`Population`) >= 500000;

-- 인구가 50만 이상인 city 중 CountryCode별 도시 평균 인구가 100만 이상 인 국가의 CountryCode, 총 도시수, 총 인구수를 조회하시오.
SELECT c.`CountryCode`, SUM(c.`Population`) `총 인구 수`, COUNT(*) AS `총 도시 수` FROM city c
WHERE c.`Population` >= 500000
GROUP BY c.`CountryCode`
HAVING AVG(c.`Population`) >= 1000000;


-- ORDER BY
-- 실습
-- country 테이블에서 대륙별로 정렬하고, 같은 대륙 내에서는 GNP가 높은 순으로 정렬하여 Name, Continent, GNP을 조회하시오 - country
SELECT c.`Name`, c.`Continent`, c.`GNP` FROM country c
ORDER BY c.`Continent`, c.`GNP` DESC;
    
-- country 테이블에서 기대수명이 짧은 순으로 정렬하되, NULL값은 마지막에 나오도록 정렬하여 Name, LifeExpectancy을 조회하시오 - country
SELECT c.`Name`, c.`LifeExpectancy` FROM country c
ORDER BY c.`LifeExpectancy` IS NULL, c.`LifeExpectancy`;

-- 대륙 별 국가 수가 많은 순서대로 Continent, 국가 수를 조회하시오. - country
SELECT c.`Continent`, COUNT(*) `국가 수` FROM country c
GROUP BY c.`Continent`
ORDER BY `국가 수` DESC;

-- 독립년도가 있는 국가들의 대륙 별 평균 기대수명이 높은 순서대로 Continent, 평균 기대수명을 조회하시오 - country
SELECT c.`Continent`, AVG(c.`LifeExpectancy`) `평균 기대수명` FROM country c
WHERE c.`IndepYear` IS NOT NULL
GROUP BY c.`Continent`
ORDER BY `평균 기대수명` DESC;


-- LIMIT, OFFSET
-- 실습
-- 인구가 많은 도시 중 11위부터 20위까지 조회 - city
SELECT c.`Name`, c.`Population` FROM city c 
ORDER BY c.`Population` DESC
LIMIT 10 OFFSET 10;

SELECT c.`Name`, c.`Population` FROM city c
ORDER BY c.`Population` DESC;
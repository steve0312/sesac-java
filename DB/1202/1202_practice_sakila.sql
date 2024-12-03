-- Active: 1732689679694@@127.0.0.1@3306@sakila
-- 적어도 한 번이라도 대여된 적이 있는 영화들 찾기
-- Subquery 적용 전
-- 영화에 대한 정보 조회
SELECT * 
FROM film f
-- WHERE 조건

-- 적어도 한 번이라도 대여된 적 있는 영화 조회
-- 영화 데이터를 조회하고자 rental에서 inventory에 접근
-- 몇 번 대여되었는지가 아니라 대여되었는지를 확인하는 것이므로 중복 데이터를 제거하고자 DISTINCT 사용
SELECT DISTINCT i.film_id
FROM rental r
JOIN inventory i ON r.inventory_id = i.inventory_id;


-- Subquery 적용 후
SELECT f.title 
FROM film f
WHERE f.film_id IN (
  SELECT DISTINCT i.film_id
  FROM rental r
  JOIN inventory i ON r.inventory_id = i.inventory_id
);

SELECT f.title
FROM film f
WHERE EXISTS (
    SELECT 1 
    FROM rental r 
    JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE i.film_id = f.film_id
);


-- 실습
-- 1. 평균 대여 금액(rental_rate)보다 비싼 영화를 조회하시오.
SELECT f.title 
FROM film f
WHERE f.rental_rate > (
  SELECT AVG(f.rental_rate)
  FROM film f
);


-- 2. 대여 횟수가 40회 이상인 고객이 대여한 영화들을 조회하시오.
-- 영화를 조회
SELECT f.title 
FROM film f
WHERE f.film_id = ();

-- 특정 고객이 대여한 (영화)
SELECT i.film_id
FROM rental r
JOIN inventory i ON r.inventory_id = i.inventory_id
WHERE cu.customer_id = ();

-- 대여 횟수가 40회 이상인 (고객)
SELECT r.customer_id
FROM rental r
GROUP BY r.customer_id
HAVING COUNT(*) >= 40

SELECT DISTINCT f.title 
FROM film f
WHERE f.film_id IN (
  SELECT i.film_id
  FROM rental r
  JOIN inventory i ON r.inventory_id = i.inventory_id
  WHERE r.customer_id IN (
    SELECT r.customer_id
    FROM rental r
    GROUP BY r.customer_id
    HAVING COUNT(*) >= 40
  )
); 

SELECT DISTINCT f.title
FROM film f
WHERE f.film_id IN (
    SELECT i.film_id
    FROM rental r
    JOIN inventory i ON r.inventory_id = i.inventory_id
    WHERE r.customer_id IN (
        SELECT customer_id
        FROM rental
        GROUP BY customer_id
        HAVING COUNT(*) >= 40
    )
);


-- 3. Action 카테고리 영화를 한번도 빌린적 없는 고객을 조회하시오.
-- Action 
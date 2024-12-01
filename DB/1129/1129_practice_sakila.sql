-- Active: 1732689679694@@127.0.0.1@3306@sakila
-- 배우와 출연 영화 목록
-- 배우 기준
SELECT actor.first_name, 
       actor.last_name, 
       film.title
FROM actor
INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id
INNER JOIN film ON film_actor.film_id = film.film_id

-- 모든 고객의 대여 현황 조회
SELECT 
    c.first_name,
    c.last_name,
    r.rental_date,
    r.return_date
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
ORDER BY c.last_name

-- 영화별 대여 현황
SELECT 
    f.title,
    r.rental_date
FROM film f
LEFT JOIN inventory i ON f.film_id = i.film_id
LEFT JOIN rental r ON i.inventory_id = r.inventory_id

-- 고객의 기본 정보, 주소 조회
SELECT c.first_name, c.last_name, a.address FROM customer c
JOIN address a ON c.address_id = a.address_id;

-- 고객의 기본 정보, 주소, 도시 조회
SELECT cu.first_name, cu.last_name, a.address, ci.city FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id;

-- 고객의 기본 정보, 주소, 도시, 국가 조회
SELECT cu.first_name, cu.last_name, a.address, ci.city, co.country FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id;

-- London(city)에 사는 고객의 기본 정보, 주소, 도시 조회
SELECT cu.first_name, cu.last_name, a.address, ci.city, co.country FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id
WHERE ci.city = 'London';

-- 도시별 고객 수 조회
SELECT ci.city, count(*) AS `도시별 고객 수` FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
GROUP BY ci.city;

-- 도시별 고객 수 조회 (내림차순)
SELECT ci.city, count(*) AS `도시별 고객 수` FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
GROUP BY ci.city
ORDER BY `도시별 고객 수` DESC;


-- 예제
-- 배우-영화 정보
-- 배우가 출연한 영화 조회
SELECT a.first_name, a.last_name, f.title FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
LEFT JOIN film f ON fa.film_id = f.film_id;

-- 영화에 출연한 배우 조회
SELECT a.first_name, a.last_name, f.title FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
LEFT JOIN actor a ON fa.actor_id = a.actor_id;

-- 출연한 배우가 없는 영화 (위에서 차이가 나는 3개)
SELECT * FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
WHERE fa.actor_id IS NULL

-- 배우별 출연 영화 수
SELECT a.actor_id, a.first_name, a.last_name, COUNT(fa.film_id) AS `배우별 출연 영화 수` FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
GROUP BY a.actor_id;

-- 영화 별 출연 배우 수
SELECT COUNT(a.actor_id) FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
LEFT JOIN actor a ON fa.actor_id = a.actor_id
GROUP BY f.film_id;

-- 위의 코드와 동일한 결과
-- film_actor의 actior_id 로도 배우의 수를 카운팅할 수 있어서 actor 테이블 join을 생략할 수 있음
SELECT COUNT(fa.actor_id) FROM film f
LEFT JOIN film_actor fa ON f.film_id = fa.film_id
GROUP BY f.film_id;

-- 영화의 카테고리 정보
SELECT f.title, c.name FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id;

-- 영화가 가지는 카테고리의 개수
SELECT f.title, COUNT(c.category_id) AS `영화가 가지는 카테고리의 개수` FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY f.film_id
ORDER BY `영화가 가지는 카테고리의 개수` DESC;

-- 카테고리 별 영화 수
SELECT c.category_id, c.name, COUNT(f.film_id) AS `카테고리 별 영화 수` FROM category c
JOIN film_category fc ON c.category_id = fc.category_id
JOIN film f ON fc.film_id = f.film_id
GROUP BY c.category_id;

-- 위의 코드와 동일한 결과1
SELECT c.name, COUNT(f.film_id) AS `카테고리 별 영화 수` FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY c.category_id;

-- 위의 코드와 동일한 결과2
SELECT c.category_id, c.name, COUNT(fc.film_id) FROM category c
JOIN film_category fc ON c.category_id = fc.category_id
GROUP BY c.category_id;

-- 배우가 출연한 영화를 카테고리 포함 조회
SELECT a.first_name, a.last_name, f.title, c.name AS category FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
LEFT JOIN film f ON fa.film_id = f.film_id
LEFT JOIN film_category fc ON f.film_id = fc.film_id
LEFT JOIN category c ON fc.category_id = c.category_id;

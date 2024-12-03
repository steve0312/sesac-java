-- Active: 1732689679694@@127.0.0.1@3306@sakila
-- 실습
-- 1. 배우가 출연한 영화의 제목을 조회
 SELECT a.first_name, a.last_name, f.title AS `출연한 영화` FROM actor a
 JOIN film_actor fa ON a.actor_id = fa.actor_id
 JOIN film f ON fa.film_id = f.film_id;
    
-- 2. first_name이 `PENELOPE` 인 배우가 출연한 영화의 제목을 조회
 SELECT a.first_name, a.last_name, f.title AS `출연한 영화` FROM actor a
 JOIN film_actor fa ON a.actor_id = fa.actor_id
 JOIN film f ON fa.film_id = f.film_id
 WHERE a.first_name = 'PENELOPE';
    
-- 3. 영화 별 출연 배우의 수를 조회
-- 영화 기준
SELECT f.film_id, f.title, COUNT(a.actor_id) AS `영화 별 출연 배우의 수` FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
JOIN actor a ON fa.actor_id = a.actor_id
GROUP BY f.film_id;

-- 배우 기준
-- 위의 코드와 동일한 결과
SELECT f.title, COUNT(a.actor_id) as actor_count
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY f.film_id, f.title

-- 4. 영화 별 출연 배우의 수가 5가 넘는 데이터를 배우의 수가 큰순으로 조회
-- 영화 기준
SELECT f.film_id, f.title, COUNT(fa.actor_id) `영화 별 출연 배우의 수` FROM film f
JOIN film_actor fa ON f.film_id = fa.film_id
GROUP BY f.film_id
HAVING `영화 별 출연 배우의 수` > 5
ORDER BY `영화 별 출연 배우의 수` DESC;

-- 배우 기준
-- 위의 코드와 동일한 결과
SELECT f.title, COUNT(a.actor_id) as actor_count
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY f.title
HAVING actor_count > 5
ORDER BY actor_count DESC;

-- 5. 고객의 대여 정보 조회
SELECT c.first_name, c.last_name, r.rental_date, r.return_date FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id;

-- 6. 고객이 대여한 영화 정보 조회
SELECT c.first_name, c.last_name, f.title FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id;

-- 7. `YENTL IDAHO` 영화를 대여한 고객 정보 조회
-- 고객 입장
SELECT c.first_name, c.last_name, f.title FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
WHERE f.title = 'YENTL IDAHO';

-- 영화 입장
-- 위의 코드와 동일한 결과
SELECT r.customer_id, r.rental_id, f.title FROM film f
JOIN inventory i ON f.film_id = i.film_id
JOIN rental r ON i.inventory_id = r.inventory_id
JOIN customer c ON r.customer_id = c.customer_id
WHERE f.title = 'YENTL IDAHO';

-- 8. 배우별로 출연한 영화의 등급(rating)을 조회
SELECT DISTINCT a.first_name, a.last_name, f.rating
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
ORDER BY a.last_name, a.first_name;

SELECT a.actor_id, a.first_name, a.last_name, f.rating AS `등급` FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id, f.film_id;

-- 9. 1번 고객이 자주 대여한 영화의 카테고리를 찾으시오
SELECT cu.first_name, cu.last_name, c.name AS `카테고리`, COUNT(c.name) AS `대여한 영화 카테고리 수` FROM customer cu
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE cu.customer_id = 1
GROUP BY cu.customer_id, c.category_id
ORDER BY `대여한 영화 카테고리 수` DESC
LIMIT 1;

SELECT COUNT(r.rental_id) AS rental_count FROM customer cu
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
WHERE cu.customer_id = 1
GROUP BY c.category_id
ORDER BY rental_count DESC
LIMIT 1;

SELECT COUNT(r.rental_id) AS rental_count FROM customer cu
JOIN rental r ON cu.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON fc.category_id = c.category_id
GROUP BY c.category_id, cu.customer_id
HAVING cu.customer_id = 1
ORDER BY rental_count DESC
LIMIT 1;

-- 10. 각 직원이 일하는 매장의 주소와 도시를 조회
SELECT s.first_name, s.last_name, a.address, c.city
FROM staff s
JOIN store st ON s.store_id = st.store_id
JOIN address a ON st.address_id = a.address_id
JOIN city c ON a.city_id = c.city_id;

-- 11. 고객별로 대여한 영화 제목과 지불한 금액, 날짜를 조회
SELECT cu.first_name, cu.last_name, f.title, p.amount, p.payment_date 
FROM customer cu
JOIN payment p ON cu.customer_id = p.customer_id
JOIN rental r ON p.rental_id = r.rental_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
GROUP BY cu.customer_id, f.title, p.amount, p.payment_date;

SELECT 
    c.first_name,
    c.last_name,
    f.title,
    p.amount,
    p.payment_date
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN payment p ON r.rental_id = p.rental_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id;

SELECT 
    c.first_name,
    c.last_name,
    f.title,
    p.amount,
    p.payment_date
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
JOIN inventory i ON r.inventory_id = i.inventory_id
JOIN film f ON i.film_id = f.film_id
JOIN payment p ON r.rental_id = p.rental_id;

-- 12. 국가별 고객 수를 조회
-- 국가 기준
SELECT co.country_id, co.country, COUNT(cu.customer_id) AS `국가별 고객 수` FROM country co
JOIN city ci ON co.country_id = ci.country_id
JOIN address a ON ci.city_id = a.city_id
JOIN customer cu ON a.address_id = cu.address_id
GROUP BY co.country_id;

-- 고객 기준
SELECT co.country_id, co.country, COUNT(cu.customer_id) AS `국가별 고객 수` FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id 
GROUP BY co.country_id;

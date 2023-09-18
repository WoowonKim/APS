-- 코드를 입력하세요
SELECT ingredient_type, SUM(a.total_order) as total_order
  FROM FIRST_HALF a
  JOIN ICECREAM_INFO b
    ON a.flavor = b.flavor
 GROUP BY b.ingredient_type
 ORDER BY total_order asc
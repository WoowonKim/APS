-- 코드를 입력하세요
SELECT f.flavor
FROM FIRST_HALF f
JOIN (
    select flavor, sum(total_order) total_order
      from july
     group by flavor) j
ON j.flavor = f.flavor
ORDER BY f.total_order + j.total_order desc
FETCH FIRST 3 ROWS ONLY



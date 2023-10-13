-- 코드를 입력하세요
SELECT fp.product_id, product_name, sum(price * amount) as total_sales
  FROM food_product fp
  JOIN food_order fo
    ON fp.product_id = fo.product_id
 WHERE to_char(produce_date, 'YYYY-MM') = '2022-05'
 GROUP BY fp.product_id, product_name
 ORDER BY total_sales desc, fp.product_id
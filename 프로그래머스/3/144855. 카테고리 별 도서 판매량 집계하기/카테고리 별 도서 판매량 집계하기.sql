-- 코드를 입력하세요
SELECT category, sum(sales) AS total_sales
  FROM book b
  JOIN book_sales bs
    ON b.book_id = bs.book_id
 WHERE to_char(bs.sales_date, 'YYYY-MM') = '2022-01'
 GROUP BY category
 ORDER BY category
    
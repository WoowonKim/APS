-- 코드를 입력하세요
SELECT b.author_id, (select author_name from author a where a.author_id = b.author_id ) as author_name,b.category, sum(b.price * bs.sales) as TOTAL_SALES
  from book b
  join book_sales bs
    on b.book_id = bs.book_id
 where to_char(bs.sales_date,'YYYY-MM') = '2022-01'
 group by b.author_id, b.category
 order by b.author_id, b.category desc
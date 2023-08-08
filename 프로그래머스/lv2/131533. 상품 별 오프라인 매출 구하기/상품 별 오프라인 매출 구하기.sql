-- 코드를 입력하세요
SELECT  p.PRODUCT_CODE, sum(sales_amount * p.price) as sales
  from product p
  join offline_sale o
    on p.product_id = o.product_id
 group by p.PRODUCT_CODE
 order by sales desc, p.PRODUCT_CODE asc
-- 코드를 입력하세요
select to_char(sales_date,'YYYY-mm-dd') as sales_date, product_id,user_id, sales_amount
from 
    (
    select Sales_date, product_id, null as user_id, sales_amount 
    from offline_sale
    union all
    SELECT Sales_date, product_id, user_id, sales_amount
    from online_sale
    order by user_id)
where to_char(sales_date,'YYYYmm') = '202203'
order by sales_date, product_id, decode(user_id,'NULL',0, 1), user_id;
with tb as (select user_id from user_info  where extract(year from joined) = 2021 )
select extract(year from sales_date) year,
       extract(month from sales_date) month,
       count(distinct user_id) PUCHASED_USERS,
       round(count(distinct user_id)/(select count(*) 
                                  from user_info 
                                 where extract(year from joined) = 2021)
                                 , 1)as PUCHASED_RATIO
  from online_sale
 where user_id in (select user_id from tb)
 group by extract(year from sales_date), extract(month from sales_date)
 
 order by year, month
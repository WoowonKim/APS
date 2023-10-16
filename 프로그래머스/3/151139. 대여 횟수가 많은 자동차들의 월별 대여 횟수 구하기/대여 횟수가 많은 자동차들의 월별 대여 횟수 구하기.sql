-- 코드를 입력하세요
SELECT extract(month from start_date) as month, car_id, count(*) as records
  FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
 where car_id in (
        select car_id
          from CAR_RENTAL_COMPANY_RENTAL_HISTORY
         WHERE to_char(start_date, 'yyyy-mm') between '2022-08' and '2022-10'
         group by car_id
        having count(*) >= 5
   ) and to_char(start_date, 'yyyy-mm') between '2022-08' and '2022-10'

 group by car_id, extract(month from start_date)
 having count(*) > 0
 order by month, car_id desc
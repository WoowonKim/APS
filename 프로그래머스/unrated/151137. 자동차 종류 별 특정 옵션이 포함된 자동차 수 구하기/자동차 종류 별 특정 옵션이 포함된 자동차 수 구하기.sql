-- 코드를 입력하세요
SELECT CAR_Type, count(car_type) Cars
from (
    select * from car_rental_company_car
        where options like '%통풍시트%' or options like '%열선시트%' or options like '%가죽시트%')
group by car_type
order by car_type
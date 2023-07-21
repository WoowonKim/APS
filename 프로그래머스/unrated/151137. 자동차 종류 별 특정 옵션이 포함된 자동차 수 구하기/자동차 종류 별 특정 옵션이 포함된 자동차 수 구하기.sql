-- 코드를 입력하세요
SELECT CAR_Type, count(car_type) Cars
from (
    select * from car_rental_company_car
        WHERE REGEXP_LIKE(OPTIONS, '통풍시트|열선시트|가죽시트'))
group by car_type
order by car_type
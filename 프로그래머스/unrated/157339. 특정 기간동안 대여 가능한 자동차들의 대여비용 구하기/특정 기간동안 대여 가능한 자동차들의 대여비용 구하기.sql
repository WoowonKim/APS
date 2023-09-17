-- SELECT  c.CAR_ID, c.CAR_TYPE c.daily_fee
-- from car_rental_company_car c
-- join car_rental_company_rental_history h
-- on c.car_id = h.car_id 
-- where c.car_type in ('세단', 'SUV') and to_char(h.end_date, 'yyyy-mm-dd') < '2022-11-01'
-- group by(c.car_id, c.car_type)

-- select car_type, duration_type, discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
-- where duration_type = '30일 이상'

-- SELECT  c.CAR_ID, c.CAR_TYPE, c.daily_fee
-- FROM car_rental_company_car c
-- join car_rental_company_rental_history h
-- on c.car_id = h.car_id 
-- where c.car_type in ('세단', 'SUV') and to_char(h.end_date, 'yyyy-mm-dd') < '2022-11-01'

select c.car_id, c.car_type, daily_fee * 30 * (1 - d.discount_rate*0.01) as fee
from car_rental_company_car c
join (
    select car_type, discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where duration_type = '30일 이상') d
on c.car_type = d.car_type
where c.car_id not in (
    SELECT DISTINCT CAR_ID
                          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                         WHERE TO_DATE('20221101', 'YYYY-MM-DD') BETWEEN START_DATE 
                           AND END_DATE
                            OR TO_DATE('20221130', 'YYYY-MM-DD') BETWEEN START_DATE 
                           AND END_DATE
)
and daily_fee * 30 * (1 - d.discount_rate*0.01) between 500000 and 2000000 - 0.00001
order by fee desc, car_type , car_id desc
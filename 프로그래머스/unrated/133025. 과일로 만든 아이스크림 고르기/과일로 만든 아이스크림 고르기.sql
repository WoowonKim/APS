-- 코드를 입력하세요
SELECT f.flavor
from icecream_info i
join first_half f 
on f.flavor = i.flavor
where i.ingredient_type = 'fruit_based' and f.total_order > 3000;

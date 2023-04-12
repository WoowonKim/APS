-- 코드를 입력하세요
SELECT pt_name, pt_no, gend_cd, age, decode(tlno,null,'NONE',tlno) as TLNO 
from patient
where age <= 12 and gend_cd = 'W'
order by age desc, pt_name asc;
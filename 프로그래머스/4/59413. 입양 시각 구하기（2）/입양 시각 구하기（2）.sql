-- 코드를 입력하세요
with tb as (SELECT LEVEL-1 TIME FROM DUAL CONNECT BY LEVEL-1 < 24)
SELECT b.time, count(a.animal_id)
  FROM animal_outs a
 RIGHT JOIN tb b
    ON B.time = to_char(a.datetime, 'HH24')
 group by b.time
 order by 1

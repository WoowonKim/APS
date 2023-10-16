-- 코드를 입력하세요
SELECT MCDP_CD as "진료과 코드", count(*) as "5월예약건수"
  FROM appointment
 WHERE to_char(APNT_YMD, 'yyyy-mm') = '2022-05'
 GROUP BY MCDP_CD
 ORDER BY "5월예약건수", "진료과 코드"

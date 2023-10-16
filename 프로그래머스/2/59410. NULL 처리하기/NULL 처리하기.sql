-- 코드를 입력하세요
SELECT ANIMAL_TYPE, decode(NAME, null, 'No name', Name), SEX_UPON_INTAKE from ANIMAL_INS order by animal_id
-- 코드를 입력하세요
SELECT ai.name, ai.datetime
  FROM animal_ins ai
  LEFT JOIN animal_outs ao
    ON ai.animal_id = ao.animal_id
 WHERE ao.animal_id IS NULL
 ORDER BY ai.datetime
 FETCH FIRST 3 ROWS ONLY
SELECT m.member_name, r.review_text, TO_CHAR(r.review_date,'YYYY-MM-DD')
  FROM rest_review r
  JOIN member_profile m
    ON r.member_id = m.member_id
 WHERE m.member_id = (
                SELECT member_id
                  FROM rest_review
                 GROUP BY member_id
                 ORDER BY count(*) desc
                 FETCH FIRST 1 ROWS ONLY
                )
 ORDER BY r.review_date, r.review_text

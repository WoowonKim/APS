-- 코드를 입력하세요
SELECT b.book_id, a.author_name, to_char(published_date, 'YYYY-MM-DD')
  FROM book b
  JOIN author a
    ON b.author_id = a.author_id
 WHERE b.category = '경제'
 ORDER BY published_date
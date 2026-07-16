-- Last updated: 7/16/2026, 4:10:36 PM
SELECT MAX(num) AS num
FROM (
    SELECT num 
    FROM MyNumbers 
    GROUP BY num 
    HAVING COUNT(num) = 1
) AS unique_nums;
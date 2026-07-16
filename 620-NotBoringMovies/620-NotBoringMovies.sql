-- Last updated: 7/16/2026, 4:10:35 PM
# Write your MySQL query statement below
SELECT id, movie, description, rating
FROM Cinema
WHERE id % 2 = 1 
  AND description != 'boring'
ORDER BY rating DESC;
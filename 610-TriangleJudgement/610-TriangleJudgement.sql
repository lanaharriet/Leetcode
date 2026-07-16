-- Last updated: 7/16/2026, 4:10:38 PM
# Write your MySQL query statement below
SELECT x, y, z,
    IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
FROM Triangle;
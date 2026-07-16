-- Last updated: 7/16/2026, 4:12:18 PM
SELECT email FROM Person
GROUP BY email
HAVING COUNT(email) > 1;
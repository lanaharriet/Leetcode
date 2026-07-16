-- Last updated: 7/16/2026, 4:12:30 PM
# Write your MySQL query statement below
SELECT P.firstName, P.lastName, A.city, A.state
FROM Person P LEFT JOIN Address A
on P.personId = A.personId
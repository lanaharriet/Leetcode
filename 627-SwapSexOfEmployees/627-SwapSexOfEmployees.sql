-- Last updated: 7/16/2026, 4:10:32 PM
# Write your MySQL query statement below
UPDATE Salary 
SET sex = IF(sex = 'm', 'f', 'm');
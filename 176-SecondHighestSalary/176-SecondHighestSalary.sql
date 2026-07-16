-- Last updated: 7/16/2026, 4:12:29 PM
select
(select distinct Salary 
from Employee order by salary desc 
limit 1 offset 1) 
as SecondHighestSalary;
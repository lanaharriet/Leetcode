-- Last updated: 7/16/2026, 4:10:40 PM
/* Write your T-SQL query statement below */
select id,
    case
        when p_id is null then 'Root'
        when id in (select distinct p_id from tree where p_id is not null) then 'Inner'
        else 'Leaf'
    end as type
from Tree
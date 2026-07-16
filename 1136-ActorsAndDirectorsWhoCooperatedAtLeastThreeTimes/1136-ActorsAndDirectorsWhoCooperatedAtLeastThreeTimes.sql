-- Last updated: 7/16/2026, 4:09:58 PM
# Write your MySQL query statement below
select actor_id, director_id 
from ActorDirector
group by actor_id, director_id 
having count(*)>=3
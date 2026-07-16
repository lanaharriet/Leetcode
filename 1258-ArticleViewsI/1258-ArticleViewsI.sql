-- Last updated: 7/16/2026, 4:09:45 PM
# Write your MySQL query statement below

select distinct author_id as id from Views
where author_id = viewer_id 
order by id;
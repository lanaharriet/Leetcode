-- Last updated: 7/16/2026, 4:09:54 PM
SELECT 
    p.project_id, 
    ROUND(AVG(e.experience_years), 2) AS average_years
FROM (
    SELECT project_id, employee_id 
    FROM Project
) p
STRAIGHT_JOIN Employee e 
ON p.employee_id = e.employee_id
GROUP BY p.project_id;
-- Last updated: 7/16/2026, 4:10:56 PM
SELECT 
    name
FROM 
    Customer
WHERE 
    referee_id != 2 
    OR referee_id IS NULL;
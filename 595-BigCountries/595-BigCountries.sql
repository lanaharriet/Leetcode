-- Last updated: 7/16/2026, 4:10:48 PM
SELECT 
    name, 
    population, 
    area
FROM 
    World
WHERE 
    area >= 3000000 
    OR population >= 25000000;
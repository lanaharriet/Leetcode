-- Last updated: 7/16/2026, 4:10:00 PM
# Write your MySQL query statement below
SELECT 
    customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT(product_key))=(
    SELECT COUNT(*) FROM Product
);
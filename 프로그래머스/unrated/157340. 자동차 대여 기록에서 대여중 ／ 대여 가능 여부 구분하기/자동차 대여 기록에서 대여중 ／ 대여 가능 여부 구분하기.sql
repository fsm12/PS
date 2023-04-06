SELECT car_id, 
    MAX(CASE WHEN '2022-10-16 00:00:00' BETWEEN DATE(start_date) and DATE(end_date) 
        THEN '대여중'
        ELSE '대여 가능'
        END) AS availability
FROM car_rental_company_rental_history
GROUP BY car_id
ORDER BY car_id DESC
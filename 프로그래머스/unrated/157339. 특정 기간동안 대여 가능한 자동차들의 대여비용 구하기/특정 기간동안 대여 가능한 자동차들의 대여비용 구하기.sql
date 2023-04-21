# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차

# 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력
SELECT car_id, car_type, fee
FROM (SELECT c.car_id, c.car_type, FLOOR(daily_fee * 30 * (SELECT (100-discount_rate) * 0.01
                                                           FROM car_rental_company_discount_plan
                                                           WHERE car_type=c.car_type AND duration_type='30일 이상')) fee
      FROM car_rental_company_car AS c
      # 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
      WHERE car_type IN ('세단', 'SUV')
      AND car_id NOT IN (SELECT car_id
                         FROM car_rental_company_rental_history
                         # 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
                         WHERE (start_date <= '2022-11-30 00:00:00')
                         AND (end_date >= '2022-11-01 00:00:00')
                         GROUP BY car_id)) AS t
WHERE fee >= 500000 AND fee < 2000000
# 대여 금액을 기준으로 내림차순 정렬, 자동차 종류를 기준으로 오름차순 정렬, 자동차 ID를 기준으로 내림차순 정렬
ORDER BY fee DESC, car_type ASC, car_id DESC
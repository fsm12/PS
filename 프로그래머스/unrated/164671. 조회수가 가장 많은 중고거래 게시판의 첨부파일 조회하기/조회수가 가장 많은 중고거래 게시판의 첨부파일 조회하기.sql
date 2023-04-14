# 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로를 조회
# /home/grep/src/ + 파일 ID, 파일 이름, 파일 확장자
SELECT CONCAT("/home/grep/src/",F.BOARD_ID,"/",F.FILE_ID,F.FILE_NAME,F.FILE_EXT) FILE_PATH
FROM USED_GOODS_FILE F JOIN USED_GOODS_BOARD B ON B.BOARD_ID = F.BOARD_ID
WHERE VIEWS = (SELECT MAX(VIEWS) 
              FROM USED_GOODS_BOARD)
ORDER BY FILE_ID DESC
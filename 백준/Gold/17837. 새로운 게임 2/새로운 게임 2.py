n,k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
# 오 왼 상 하
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
# 왼 오 하 상
change_dir = [1, 0, 3, 2]
chess = []
chessPiecesInPos = [[[] for _ in range(n)] for _ in range(n)]

for i in range(k):
    x, y, d = map(int, input().split())
    chess.append([x-1, y-1, d-1])
    chessPiecesInPos[x-1][y-1].append(i)

def solve(i):
    # 2. 체스말 하나 가져오기
    x, y, d = chess[i]
    nx = x + dx[d]
    ny = y + dy[d]
    # 3. 맵밖이거나 파란색이면 - 반대방향
    if 0 > nx or nx >= n or 0 > ny or ny >= n or board[nx][ny] == 2:
        d = change_dir[d]
        chess[i][2] = d
        nx = x + dx[d]
        ny = y + dy[d]
        if 0 > nx or nx >= n or 0 > ny or ny >= n or board[nx][ny] == 2:
            return True

    # 4. 체스말이 누적되었을때의 각 체스말의 정보 저장
    heights = []
    for ch_idx, ch_num in enumerate(chessPiecesInPos[x][y]):
        if ch_num == i:
            heights.extend(chessPiecesInPos[x][y][ch_idx:])
            chessPiecesInPos[x][y] = chessPiecesInPos[x][y][:ch_idx]
            break

    # 5. 빨간색이면 순서 반대
    if board[nx][ny] == 1:
        heights = heights[-1::-1]

    # 6. 같은 위치의 말이 있다면 같이 이동
    for chs in heights:
        chess[chs][0], chess[chs][1] = nx, ny
        chessPiecesInPos[nx][ny].append(chs)

    # 7. 탈출조건 - 4개이상 쌓였는가
    if len(chessPiecesInPos[nx][ny]) >= 4:
        return False
    return True

turn = 0
while True:
    end = False
    if turn > 1000:
        print(-1)
        break
    # 1. K개의 체스말을 이동
    for i in range(k):
        if not solve(i):
            end = True
            break
    turn += 1
    if end:
        print(turn)
        break
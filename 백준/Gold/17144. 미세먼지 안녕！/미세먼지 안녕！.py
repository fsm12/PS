import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	512 MB

[입력]
1> R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
R>  Ar,c (-1 ≤ Ar,c ≤ 1,000) (설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양)
			(-1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.)
=> T초가 지난 후 구사과 방에 남아있는 미세먼지의 양

공기청정기는 항상 1번 열에 설치

1. 미세먼지가 확산
확산은 미세먼지가 있는 모든 칸에서 동시 (공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않음)
확산되는 양은 Ar,c/5
(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)

2. 공기청정기가 작동
위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환
바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동

그대로 구현
"""

def solution():
    def dustSpread():
        while dusts:
            now = dusts.popleft()
            # 맵값이 5보다 작으면 /5 의미없음
            if now[2] < 5:
                continue

            cnt, amount = 0, now[2] // 5
            for i in range(4):
                nr, nc = now[0] + dr[i], now[1] + dc[i]
                if 0 <= nr < R and 0 <= nc < C and board[nr][nc] != -1:
                    board[nr][nc] += amount
                    cnt += 1

            board[now[0]][now[1]] -= amount * cnt

    def windSpread():
        for r in range(top - 1, 0, -1):
            board[r][0] = board[r - 1][0]

        for c in range(0, C - 1):
            board[0][c] = board[0][c + 1]

        for r in range(0, top):
            board[r][C - 1] = board[r + 1][C - 1]

        for c in range(C - 1, 1, -1):
            board[top][c] = board[top][c - 1]

        board[top][1] = 0

        for r in range(top + 2, R - 1):
            board[r][0] = board[r + 1][0]

        for c in range(0, C - 1):
            board[R - 1][c] = board[R - 1][c + 1]

        for r in range(R - 1, top + 1, -1):
            board[r][C - 1] = board[r - 1][C - 1]

        for c in range(C - 1, 1, -1):
            board[top + 1][c] = board[top + 1][c - 1]

        board[top + 1][1] = 0

    top = -1
    for r in range(R):
        if board[r][0] == -1:
            top = r
            break

    # T초동안
    for t in range(T):
        # 먼지위치 저장
        dusts = deque()
        for r in range(R):
            for c in range(C):
                if board[r][c] != 0 and board[r][c] != -1:
                    dusts.append((r, c, board[r][c]))
        # 먼지 확산
        dustSpread()
        # 공기청정
        windSpread()

    ans = 0
    for r in range(R):
        ans += sum(board[r])
    print(ans+2)


if __name__ == "__main__":
    R, C, T = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(R)]
    dr, dc = (-1, 1, 0, 0), (0, 0, -1, 1)
    solution()

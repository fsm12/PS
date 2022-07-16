import sys
from collections import deque

input = sys.stdin.readline

def bfs(x, y):
    cnt = 1
    dq = deque()
    dq.append((x, y))
    vis[x][y] = True

    while dq:
        x, y = dq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == 1 and not vis[nx][ny]:
                    vis[nx][ny] = True
                    dq.append((nx, ny))
                    cnt += 1
    return cnt


n, m = map(int, input().split())
vis = [[False] * m for _ in range(n)]
board = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

cnt, mx = 0, 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and not vis[i][j]:
            cnt += 1
            mx = max(mx, bfs(i, j))
print(cnt)
print(mx)

import sys
from collections import deque

def labeling_island():
    num = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                num -= 1
                queue = deque([])
                queue.append([i, j])
                board[i][j] = num
                island[num] = []
                while queue:
                    r, c = queue.popleft()
                    check = False
                    for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        nr = r+dr
                        nc = c+dc
                        if 0<=nr<=n-1 and 0<=nc<=n-1:
                            if board[nr][nc] == 1:
                                board[nr][nc] = num
                                queue.append([nr, nc])
                            elif not board[nr][nc]:
                                check = True
                    if check:
                        island[num].append([r, c])

def calc_distance(i, j, num):
    global dist
    queue = deque([])
    queue.append([i, j])
    board_[i][j] = 0
    while queue:
        r, c = queue.popleft()
        for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            nr = r + dr
            nc = c + dc
            if 0<=nr<=n-1 and 0<=nc<=n-1:
                if 0 == board_[nr][nc] or board_[r][c] + 1 < board_[nr][nc]:
                    queue.append([nr, nc])
                    board_[nr][nc] = board_[r][c] + 1

                elif board_[nr][nc] < 0 and board_[nr][nc] != num:
                    board_[i][j] = num
                    dist = min(board_[r][c], dist)
                    return
    board_[i][j] = num

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
island = {}
labeling_island()

dist = sys.maxsize
for num, array in island.items():
    board_ = [x[:] for x in board]
    for i, j in array:
        calc_distance(i, j, num)

print(dist)
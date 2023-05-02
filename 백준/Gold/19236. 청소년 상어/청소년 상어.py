import copy
import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline


def move_fish(sx, sy, board):
    for f in range(1, N * N + 1):
        # 물고기 위치 찾기
        fx, fy = -1, -1
        for x in range(N):
            for y in range(N):
                if board[x][y][0] == f:
                    fx, fy = x, y
                    break
        if fx == -1 and fy == -1:
            continue
        fd = board[fx][fy][1]

        # 8방 확인하며
        for i in range(8):
            nd = (fd + i) % 8
            nx = fx + dx[nd]
            ny = fy + dy[nd]
            # 맵 안이고 상어 자리가 아니면 갈 수 있음
            if 0 <= nx < N and 0 <= ny < N and not (nx == sx and ny == sy):
                board[fx][fy][1] = nd
                board[fx][fy], board[nx][ny] = board[nx][ny], board[fx][fy]
                break


def move_shark(sx, sy, eat, board) -> None:
    # 상어의 방향은 먹은 물고기의 방향 
    sd = board[sx][sy][1]
    # 1~3칸 상어 이동 가능
    for i in range(1, 4):
        nx = sx + dx[sd] * i
        ny = sy + dy[sd] * i
        # 맵안이고 유효한 물고기 id면 갈 수 있음
        if 0 <= nx < N and 0 <= ny < N and 0 < board[nx][ny][0]:
            dfs(nx, ny, eat, copy.deepcopy(board))


def dfs(sx, sy, eat, grid):
    global ans
    # 1. 물고기 먹기 
    eat += grid[sx][sy][0]
    ans = max(ans, eat)
    grid[sx][sy][0] = 0
    
    # 2. 물고기 이동
    move_fish(sx, sy, grid)
    
    # 3. 상어 이동
    move_shark(sx, sy, eat, grid)

if __name__ == "__main__":
    N, ans = 4, 0
    dx, dy = (-1, -1, 0, 1, 1, 1, 0, -1), (0, -1, -1, -1, 0, 1, 1, 1)
    
    board = [[[0, 0] for _ in range(N)] for _ in range(N)]
    for i in range(N):
        inp = list(map(int, input().split()))
        for j in range(N):
            board[i][j][0] = inp[2 * j]
            board[i][j][1] = inp[2 * j + 1] - 1

    dfs(0, 0, 0, board)
    print(ans)

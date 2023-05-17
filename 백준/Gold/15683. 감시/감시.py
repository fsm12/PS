import copy
import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
0은 빈 칸, 6은 벽, 1~5는 CCTV
사각 지대의 최소 크기

dfs로 진행
각 CCTV 유형은 리스트로 미리 저장해두기
"""


def solution():
    global ans

    def fill(board, x, y, mode_list):
        for dir in mode_list:
            nx, ny = x, y
            while True:
                nx += dxy[dir][0]
                ny += dxy[dir][1]
                if 0 <= nx < N and 0 <= ny < M:
                    if board[nx][ny] == 0:
                        board[nx][ny] = -1
                    elif board[nx][ny] == 6:
                        break
                else:
                    break
        return board

    def dfs(curMap, depth):
        global ans
        if depth == len(cctv):
            cur_sum = 0
            for n in range(N):
                for m in range(M):
                    if curMap[n][m] == 0:
                        cur_sum += 1
            ans = min(ans, cur_sum)
            return
        x, y, num = cctv[depth]
        for mode_list in mode[num - 1]:
            temp = copy.deepcopy(curMap)
            dfs(fill(temp, x, y, mode_list), depth + 1)

    dfs(grid, 0)
    print(ans)


if __name__ == "__main__":
    N, M = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(N)]
    cctv = []
    for i in range(N):
        for j in range(M):
            if 1 <= grid[i][j] <= 5:
                cctv.append((i, j, grid[i][j]))
    dxy = ((-1, 0), (0, 1), (1, 0), (0, -1))
    mode = [
        [[0], [1], [2], [3]],
        [[0, 2], [1, 3]],
        [[0, 1], [1, 2], [2, 3], [3, 0]],
        [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
        [[0, 1, 2, 3]],
    ]
    ans = N*M
    solution()

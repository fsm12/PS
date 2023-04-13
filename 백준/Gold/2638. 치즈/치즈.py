import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	128 MB

[입력]
1> N, M (5 ≤ N, M ≤ 100)
N> 맵
=> 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 정수로 첫 줄에 출력

sol) BFS
치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정
=> 외부에서 접근하면 내부 공간은 만나지 않음
맵에 가장 밖에서부터 접근 했을 때 1(치즈)이 있는 칸에 2번이상 방문 가능하면 삭제
"""

def solution():
    ans = 0

    while True:
        q = deque()
        vis = [[0 for _ in range(M)] for _ in range(N)]
        vis[0][0] = 1
        q.append((0, 0))
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if 0 <= nx < N and 0 <= ny < M and not vis[nx][ny]:
                    if board[nx][ny]:
                        board[nx][ny] += 1
                    else:
                        vis[nx][ny] = 1
                        q.append((nx, ny))

        isEmpty = True
        for i in range(N):
            for j in range(M):
                if board[i][j] >= 3:
                    board[i][j] = 0
                elif board[i][j] > 0:
                    board[i][j] = 1
                    isEmpty = False
        ans += 1

        if isEmpty:
            print(ans)
            break

if __name__ == "__main__":
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    dx, dy = (1, -1, 0, 0), (0, 0, 1, -1)
    solution()
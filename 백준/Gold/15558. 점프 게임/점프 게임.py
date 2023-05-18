import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
BFS
i+1, i-1, i+k로 진행하면서 타일을 벗어날 수 있으면 true, 불가능했다면 false로 반환
"""

def bfs():
    q = deque()
    q.append((0, 0))
    drop_idx = 0
    while q:
        for _ in range(len(q)):
            is_left, idx = q.popleft()
            for nx, ny in ((is_left, idx + 1), (is_left, idx - 1), (abs(1 - is_left), idx + K)):
                if ny >= N:
                    return 1
                if drop_idx < ny < N and jump[nx][ny] and not vis[nx][ny]:
                    q.append((nx, ny))
                    vis[nx][ny] = True
        drop_idx += 1
    return 0


if __name__ == "__main__":
    N, K = map(int, input().split())
    jump = [list(map(int, input().strip())) for _ in range(2)]
    vis = [[False for _ in range(N)] for _ in range(2)]
    print(bfs())

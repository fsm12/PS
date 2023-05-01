import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
bfs
맵에 1값을 가지는 구역별로 2,3.. 으로 구간 나누기 (딕셔너리로 저장)
0값을 가진 좌표들을 미리 저장하고 이를 순회하며 저장해둔 구역 번호로 vis set을 확인하면서 구역 max값 찾기 
"""

def solution():
    def makeShape(x: int, y: int) -> None:
        global ck
        ck += 1
        grid[x][y] = ck
        q = deque()
        q.append((x,y))
        cnt = 1

        while q:
            node = q.popleft()
            for i in range(4):
                nx, ny = node[0] + dx[i], node[1] + dy[i]
                if 0 <= nx < N and 0 <= ny < M and grid[nx][ny] == 1:
                    q.append((nx, ny))
                    grid[nx][ny] = ck
                    cnt += 1
        area_info[ck] = cnt

    for n in range(N):
        for m in range(M):
            if grid[n][m] == 0:
                zero.append((n, m))
            if grid[n][m] == 1:
                makeShape(n, m)

    ans = 0
    for z in zero:
        vis = set()
        size = 1
        for i in range(4):
            nx, ny = z[0] + dx[i], z[1] + dy[i]
            if 0 <= nx < N and 0 <= ny < M and grid[nx][ny] != 0:
                if grid[nx][ny] not in vis:
                    vis.add(grid[nx][ny])
                    size += area_info[grid[nx][ny]]
        ans = max(ans, size)
    print(ans)


if __name__ == '__main__':
    N, M = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(N)]
    zero = []
    area_info = {}
    ck = 1
    dx, dy = (-1, 1, 0, 0), (0, 0, -1, 1)
    solution()

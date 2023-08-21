import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 0, 1, 0] #상, 좌, 하, 우
dy = [0, -1, 0, 1]

cnt, result, x, y, shark_size = 0, 0, 0, 0, 2

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] == 9:
            x = i
            y = j

def BFS(x, y, shark_size):
    dist = [[0] * n for _ in range(n)]
    vis = [[False] * n for _ in range(n)]

    q = deque()
    q.append((x, y))
    vis[x][y] = True
    temp = []
    while q:
        # 1. 큐에서 꺼냄
        cur_x, cur_y = q.popleft()
        # 2. 연결되어 있는가
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            # 3-1. 갈 수 있는가 - 맵 안이고, 방문하지 않았을때
            if 0 <= nx < n and 0 <= ny < n and vis[nx][ny] == False:
                # 3-1. 갈 수 있는가 - 물고기의 크기가 상어크기보다 같거나 작을 때
                if graph[nx][ny] <= shark_size:
                    # 4. 큐에넣음
                    q.append((nx, ny))
                    # 5. 체크인
                    vis[nx][ny] = True

                    dist[nx][ny] = dist[cur_x][cur_y] + 1
                    if graph[nx][ny] < shark_size and graph[nx][ny] != 0:
                        temp.append((nx, ny, dist[nx][ny]))

    # 거리 오름차순 -> x좌표 오름차순 -> y좌표 오름차순
    return sorted(temp, key=lambda x: (-x[2], -x[0], -x[1]))


while True:
    fishEatenByShark = BFS(x, y, shark_size)
    #print(fishEatenByShark)

    if len(fishEatenByShark) == 0:
        break

    nx, ny, dist = fishEatenByShark.pop()

    result += dist
    graph[x][y], graph[nx][ny] = 0, 0

    x, y = nx, ny
    cnt += 1
    if cnt == shark_size:
        shark_size += 1
        cnt = 0
print(result)
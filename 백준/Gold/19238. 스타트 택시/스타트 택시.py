from collections import deque

dxy = [[1, 0], [0, 1], [-1, 0], [0, -1]]

def findPassengerStart(taxi):
    q = deque()
    q.append(taxi)
    visited = [[0] * N for _ in range(N)]
    minDistance = float('inf')
    passenger = []
    while q:
        x,y = q.popleft()
        if visited[x][y] > minDistance:
            break
        if [x,y] in passenger_start:
            minDistance = visited[x][y]
            passenger.append([x, y])
        else:
            for d in range(4):
                nx, ny = x + dxy[d][0], y + dxy[d][1]
                if 0 <= nx < N and 0 <= ny < N and board[nx][ny] != 1 and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx, ny])
    if passenger:
       passenger.sort()
       return visited[passenger[0][0]][passenger[0][1]], passenger[0][0], passenger[0][1]
    else:
       return -1, -1, -1


def findPassengerDesti(start, end):
    q = deque()
    q.append(start)
    visited = [[0] * N for _ in range(N)]
    while q:
        x,y = q.popleft()
        if [x,y] == end:
            break
        for d in range(4):
            nx, ny = x + dxy[d][0], y + dxy[d][1]
            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] != 1 and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
    return visited[x][y], x, y


if __name__ == "__main__":
    N, M, fuel = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    intialX, initialY = map(int, input().split())
    taxi = [intialX - 1, initialY - 1]

    passenger_start = []
    passenger_end = []
    for _ in range(M):
        sx, sy, ex, ey = map(int, input().split())
        passenger_start.append([sx - 1, sy - 1])
        passenger_end.append([ex - 1, ey - 1])

    for _ in range(M):
        #1.현재 택시위치로부터 가장 가까운 승객의 출발지를 찾기
        distS, sx, sy = findPassengerStart(taxi)
        # 승객에게 도달 불가 or 연료부족일때
        if distS == -1 or fuel < distS:
            fuel = -1
            break
        # 도달 가능하다면 연료 -, 승객은 택시에 탔으니, 해당승객의 출발지 제거
        fuel -= distS
        idx = passenger_start.index([sx, sy])
        passenger_start[idx] = [-1, -1]

        #2. 승객의 출발지로부터 도착지까지 최단경로
        distD, dx, dy = findPassengerDesti([sx, sy], passenger_end[idx])
        # 목적지에 도달 불가 or 연료부족일때
        if [dx, dy] != passenger_end[idx] or fuel < distD:
            fuel = -1
            break
        # 도달 가능하다면 연료 쓴만큼 +, 택시 위치 갱신
        fuel += distD
        taxi = [dx, dy]

    print(fuel)
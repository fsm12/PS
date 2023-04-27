import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1> T [1,100]
T> N [1,10^7]
=> ADDH, ADDT, MINT, ADDO, MINO 버튼을 누르는 횟수 (사전 순으로 가장 앞서는 방법을 출력)

sol) bfs
60 이상이 필요하면 ADDH를 누르는게 이득임
60까지의 버튼 누르는 경우를 구하고 60단위만큼 ADDH 누르기 
"""

def bfs():
    q = deque()
    # 누적시간, ADDH, ADDT, MINT, ADDO, MINO 버튼 누른 횟수
    q.append((0, 0, 0, 0, 0, 0))

    while q:
        node = q.popleft()
        if 0 <= node[0] <= 60 and not vis[node[0]]:
            button[node[0]] = (node[1], node[2], node[3], node[4], node[5])
            vis[node[0]] = True
            # 사전순
            q.append((node[0] - 1, node[1], node[2], node[3], node[4], node[5] + 1))
            q.append((node[0] + 1, node[1], node[2], node[3], node[4] + 1, node[5]))
            q.append((node[0] - 10, node[1], node[2], node[3] + 1, node[4], node[5]))
            q.append((node[0] + 10, node[1], node[2] + 1, node[3], node[4], node[5]))
            q.append((node[0] + 60, node[1] + 1, node[2], node[3], node[4], node[5]))


if __name__ == '__main__':
    button = [(0, 0, 0, 0, 0) for _ in range(61)]
    vis = [False for _ in range(61)]
    bfs()
    
    T = int(input())
    for _ in range(T):
        N = int(input())
        i = N % 60
        print(button[i][0] + N // 60, button[i][1], button[i][2], button[i][3], button[i][4])

import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
플로이드로 채우기
k로 거쳐가야 최단경로라면 k로 기록
"""

def solution():
    for i in range(N + 1):
        for j in range(N + 1):
            if i == j:
                dist[i][j] = 0
                ans[i][j] = 10000

    for _ in range(M):
        v1, v2, weight = map(int, input().split())
        dist[v1][v2] = weight
        dist[v2][v1] = weight

        # 기본값
        ans[v1][v2] = v2
        ans[v2][v1] = v1

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
                    ans[i][j] = ans[i][k]

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if ans[i][j] == 10000:
                print('-', end=' ')
            else:
                print(ans[i][j], end=' ')
        print()


if __name__ == "__main__":
    N, M = map(int, input().split())
    dist = [[10000 for _ in range(N + 1)] for _ in range(N + 1)]
    ans = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
    solution()
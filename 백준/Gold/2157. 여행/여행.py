import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초	128 MB

[입력]
1> N(1 ≤ N ≤ 300), M(2 ≤ M ≤ N), K(1 ≤ K ≤ 100,000)
K> 항공로에 대한 정보를 나타내는 세 정수 a, b, c(1 ≤ a, b ≤ N, 1 ≤ c ≤ 10,000)
    a번 도시에서 b번 도시로 이동하는 항로가 있고, 서비스되는 기내식의 점수가 c점
=> 기내식 점수의 총 합의 최댓값을 출력

M개 이하의 도시를 지나는 여행
여행 경로는 반드시 1번 도시에서 시작해서 N번 도시에서 끝나야 함
도시 번호가 증가하는 순서대로만 이동

sol) dp
전 케이스에서 도시를 하나 더 선택했을 때 최댓값을 가지도록 갱신하는 dp 테이블 생성
"""

def solution():
    for i in range(1, N + 1):
        dp[2][i] = adjMatrix[1][i]

    for i in range(2, N + 1):
        for j in range(i + 1, N + 1):
            for k in range(2, M):
                if adjMatrix[i][j] != 0 and dp[k][i] != 0:
                    dp[k + 1][j] = max(dp[k + 1][j], dp[k][i] + adjMatrix[i][j])

    print(max([dp[i][N] for i in range(1, M + 1)]))

if __name__ == "__main__":
    N, M, K = map(int, input().split())
    adjMatrix = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
    dp = [[0 for _ in range(N + 1)] for _ in range(M + 1)]
    for _ in range(K):
        a, b, c = map(int, input().split())
        if a < b:
            adjMatrix[a][b] = max(adjMatrix[a][b], c)
    solution()

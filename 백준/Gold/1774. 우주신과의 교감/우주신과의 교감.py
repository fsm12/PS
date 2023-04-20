import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초	128 MB

[입력]
1> 우주신들의 개수(N<=1,000) 이미 연결된 신들과의 통로의 개수(M<=1,000)
N> 황선자를 포함하여 우주신들의 좌표가 (0<= X<=1,000,000), (0<=Y<=1,000,000)
M> 이미 연결된 통로가 주어진다. 번호는 위의 입력받은 좌표들의 순서라고 생각하면 된다. 좌표는 정수
=> 만들어야 할 최소의 통로 길이 (출력은 소수점 둘째짜리까지)

통로들의 길이는 2차원 좌표계상의 거리

sol) MST
가능한 간선 정보를 담고 거리가 짧은 순으로 꺼내 크루스칼
"""

def solution():
    def find(node: int) -> int:
        if node == parent[node]:
            return parent[node]
        parent[node] = find(parent[node])
        return parent[node]

    def union(a: int, b: int) -> None:
        a, b = find(a), find(b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    for n in range(1, N + 1):
        points[n] = tuple(map(int, input().split()))

    #  가능한 거리 구하기
    for i in range(1, N + 1):
        for j in range(i + 1, N + 1):
            nodes.append([((points[i][0] - points[j][0]) ** 2 + (points[i][1] - points[j][1]) ** 2) ** 0.5, i, j])

    # 이미 이어진 통로 UF
    for _ in range(M):
        a, b = map(int, input().split())
        union(a, b)

    # 짧은 거리부터 통로 UF
    nodes.sort()
    ans = 0
    for p in nodes:
        cost, x, y = p[0], p[1], p[2]

        if find(x) != find(y):
            union(x, y)
            ans += cost

    print("{:.2f}".format(ans))


if __name__ == "__main__":
    N, M = map(int, input().split())
    # 부모 초기화
    parent = [n for n in range(N + 1)]
    points = [0 for _ in range(N + 1)]
    nodes = []
    solution()

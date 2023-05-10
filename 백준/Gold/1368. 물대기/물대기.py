import sys
import heapq

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
우물파기, 논 연결
가상의 노드 추가해서 그래프로 연결
MST
"""


def solution():
    def find(a):
        while a != parents[a]:
            a = parents[a]
        return a

    def union(a, b):
        na, nb = find(a), find(b)
        if na < nb:
            parents[find(nb)] = find(na)
        else:
            parents[find(na)] = find(nb)

    ans = 0
    while q:
        cost, s, e = heapq.heappop(q)
        if find(s) != find(e):
            union(s, e)
            ans += cost
    print(ans)

if __name__ == "__main__":
    N = int(input())
    parents = [i for i in range(N + 1)]
    q = []
    for n in range(N):
        heapq.heappush(q, (int(input()), n, N))
    matrix = [list(map(int, input().split())) for _ in range(N)]
    for i in range(N):
        for j in range(i+1, N):
            heapq.heappush(q, (matrix[i][j], i, j))
    solution()

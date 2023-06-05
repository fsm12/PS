import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
각 별에 대해 거리를 구하고 MST
"""

def solution():
    def find(node):
        while node != parent[node]:
            node = parent[node]
        return node

    def union(a, b):
        na, nb = find(a), find(b)
        if na < nb:
            parent[find(nb)] = find(na)
        else:
            parent[find(na)] = find(nb)

    dist = []
    for i in range(N - 1):
        for j in range(i + 1, N):
            dist.append(((((stars[i][0] - stars[j][0]) ** 2 + (stars[i][1] - stars[j][1]) ** 2) ** 0.5), i, j))
    dist.sort()

    ans = 0
    for weight, i, j in dist:
        if find(i) != find(j):
            union(i, j)
            ans += weight
    print(round(ans, 2))

if __name__ == "__main__":
    N = int(input())
    stars = [tuple(map(float, input().split())) for _ in range(N)]
    parent = [n for n in range(N)]
    solution()

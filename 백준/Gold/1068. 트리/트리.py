import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
bfs로 지울노드가 아니면 내려가면서 리프노드를 만나면 카운트 증가 => 78퍼 틀렸습니다
dfs로 지울 노드면 adjList에 추가하지 않고, 내려가면서 리프노드면 카운트 증가
"""

def dfs(node):
    global ans
    if not adjList[node]:
        ans += 1
        return

    for next in adjList[node]:
        dfs(next)


if __name__ == "__main__":
    N = int(input())
    adjList = [[] for _ in range(N)]
    li = list(map(int, input().split()))
    M = int(input())
    
    root = -1
    for i, num in enumerate(li):
        if num == -1:
            root = i
        elif i == M:
            continue
        else:
            adjList[num].append(i)
    ans = 0
    if root != M:
        dfs(root)
    print(ans)

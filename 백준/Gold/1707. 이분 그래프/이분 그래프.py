import sys
sys.setrecursionlimit(10**6)

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
두 그룹으로 방문처리를 하면서 같은 집합인지 아닌지를 판단
"""

def DFS(start, type, vis):
    vis[start] = type

    # 인접 노드들이
    for v in adjList[start]:
        # 방문전이라면
        if vis[v] == 0:
            # 다른 집합에 속하도록 -type으로 dfs
            flag = DFS(v, -type, vis)
            if not flag:
                return False
        # 방문했는데
        else:
            # 현재 타입과 같다면 이분그래프가 아님
            if vis[v] == type:
                return False
    return True

if __name__ == "__main__":
    K = int(input())
    for _ in range(K):
        V, E = map(int, sys.stdin.readline().split())
        adjList = [[] for _ in range(V+1)]
        vis = [0 for _ in range(V+1)]
        for _ in range(E):
            u, v = map(int, sys.stdin.readline().split())
            adjList[u].append(v)
            adjList[v].append(u)

        # 모든 노드들에 대해
        for v in range(1, V+1):
            # 방문전이면
            if vis[v] == 0:
                # 1이라는 타입으로 dfs
                flag = DFS(v, 1, vis)
                if not flag:
                    break

        print("YES" if flag else "NO")
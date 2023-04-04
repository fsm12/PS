import sys
sys.setrecursionlimit(10**6)

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
3 초	256 MB

[입력]
1> T
1> 학생의 수 n (2 ≤ n ≤ 100,000)
1> 선택된 학생들의 번호
=> 각 줄에는 프로젝트 팀에 속하지 못한 학생들의 수 출력

sol)
A노드가 타고들어가서 A로 올수있으면 같은 팀이라 볼 수 있음 -> dfs
검사를 한 노드인지 사이클을 돌고있는 노드인지를 둘다 방문처리해야 하므로 vis, done배열로 저장하기
"""


def dfs(n: int) -> None:
    global attend
    if done[n]:
        return
    if vis[n]:
        done[n] = True
        attend += 1

    vis[n] = True
    dfs(arr[n] - 1)
    done[n] = True
    vis[n] = False


if __name__ == "__main__":
    T = int(input())
    for t in range(T):
        attend = 0
        N = int(input())
        arr = list(map(int, input().split()))
        vis = [False for _ in range(N)]
        done = [False for _ in range(N)]
        for n in range(N):
            dfs(n)
        print(N - attend)

import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	128 MB

[입력]
1> N : 구슬의 개수(1 ≤ N ≤ 99)  M : 저울에 올려 본 쌍의 개수(1 ≤ M ≤ N(N-1)/2)
M> 두 개의 구슬 번호(앞 번호의 구슬이 뒤 번호의 구슬보다 무겁다)
=> 무게가 중간이 절대로 될 수 없는 구슬의 수

sol)
중간이 될 수 없다 => 특정 구슬 기준으로 큰 구슬과 작은구슬의 개수로 판단
"""


def solution():
    global cnt
    def dfs(arr, idx):
        global cnt
        for num in arr[idx]:
            if not vis[num]:
                vis[num] = True
                cnt += 1
                dfs(arr, num)

    ans = 0
    for n in range(1, N + 1):
        vis = [False for _ in range(N + 1)]

        cnt = 0
        dfs(big_list, n)
        if cnt >= (N + 1) / 2:
            ans += 1

        cnt = 0
        dfs(small_list, n)
        if cnt >= (N + 1) / 2:
            ans += 1

    print(ans)

if __name__ == "__main__":
    N, M = map(int, input().split())

    big_list = [[] for _ in range(N + 1)]
    small_list = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        big_list[b].append(a)
        small_list[a].append(b)

    cnt = 0
    solution()
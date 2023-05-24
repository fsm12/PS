import sys
from collections import defaultdict

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
슬라이딩 윈도우
처음 K개를 먼저 담고 하나를 빼고 더하는 식으로 연산
"""

def solution():
    cnt = 0
    for k in range(K):
        if visCnt[arr[k]] == 0:
            cnt += 1
        visCnt[arr[k]] += 1

    ans = cnt
    for n in range(1, N):
        if ans <= cnt:
            if visCnt[C] == 0:
                ans = cnt + 1
            else:
                ans = cnt
        
        visCnt[arr[n - 1]] -= 1
        if visCnt[arr[n - 1]] == 0:
            cnt -= 1

        if visCnt[arr[(n + K - 1) % N]] == 0:
            cnt += 1
        visCnt[arr[(n + K - 1) % N]] += 1
    print(ans)


if __name__ == "__main__":
    N, D, K, C = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    visCnt = [0 for _ in range(D + 1)]
    solution()

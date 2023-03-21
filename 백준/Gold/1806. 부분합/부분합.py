import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
0.5 초(Java 1초)	128 MB

[입력]
1> N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)
1> N개로 구성된 수열
=> 구하고자 하는 최소의 길이(불가능 0)

sol) 투포인터
"""

def solution():
    sp, ep, cur, ans = 0, 0, arr[0], N + 1
    while sp <= ep:
        if cur >= S:
            ans = min(ans, ep - sp + 1)
            if ans == 1:
                break
            cur -= arr[sp]
            sp += 1
        else:
            ep += 1
            if ep >= N:
                if ans == N + 1:
                    ans = 0
                break
            cur += arr[ep]
    print(ans)


if __name__ == "__main__":
    N, S = map(int, input().split())
    arr = list(map(int, input().split()))
    solution()

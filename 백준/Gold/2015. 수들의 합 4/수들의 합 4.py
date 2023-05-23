import sys
from collections import defaultdict

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
sol 1) 정렬 + 투포인터
중복되는 값은 dict로 카운트하고 누적합 값 나올때마다 해당 개수를 곱해서 구해줌

sol 2)
누적합 S배열 생성
S[i] - S[i-1] = K => S[i] - K = S[i-1]
중복된 값을 dict에 담아서 개수만큼 증가
"""

def solution():
    for i in range(1, len(S)):
        S[i] += S[i - 1]

    cnt = 0
    for i in range(len(S)):
        if S[i] == K:
            cnt += 1
        cnt += pre[S[i] - K]
        pre[S[i]] += 1
    print(cnt)

if __name__ == "__main__":
    N, K = map(int, input().split())
    S = list(map(int, input().split()))
    pre = defaultdict(int)
    solution()
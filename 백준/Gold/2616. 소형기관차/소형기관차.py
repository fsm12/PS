import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
소형 기관차 3대를 이용하여 최대로 운송할 수 있는 손님 수

현재 객체 칸부터 최대로 끌수 있는 객차범위까지를 담은 누적합을 이용한 DP..?
객차는 단 3개니까 3개까지의 객차에 대한 각 경우의 누적합

dp[n][m] = m번째 객차에 대해 소형 기관차 n개 까지 운영했을 때 최대 손님수

무조건 모든 소형 기관차가 최대의 객차를 끌어야 손님을 최대로 운송 가능함
손님을 운송하기 위해서는 무조건 기관차가 해당 칸을 선택해야함
=> 이전 기관차를 선택한 값 그대로 vs 현 기관차를 고른 경우 중에서 큰값

"""

def solution():
    dp = [[0 for _ in range(N + 1)] for _ in range(4)]
    for i in range(1, 4):
        for j in range(M * i, N + 1):
            dp[i][j] = max(dp[i][j - 1], dp[i - 1][j - M] + sum(nums[j - M:j]))
    print(dp[3][N])


if __name__ == "__main__":
    N = int(input())
    nums = list(map(int, input().split()))
    M = int(input())
    solution()

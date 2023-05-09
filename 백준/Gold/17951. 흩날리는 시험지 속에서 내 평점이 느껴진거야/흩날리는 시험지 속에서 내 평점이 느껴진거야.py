import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
이분탐색
mid = 한 그룹에서 만들 수 있는 최대 점수
앞에서부터 더한 값이 mid를 넘으면 무조건 그룹이 쪼개져야 함
최종적으로 만든 그룹의 수가 K보다 작으면 mid 보다 큰 값을 기준으로, 반대라면 mid보다 작은 값을 기준으로 잡기  
"""


def solution():
    l, h = 0, sum(scores)
    while l <= h:
        mid, cur_sum, group_cnt = (l + h) // 2, 0, 1
        for score in scores:
            cur_sum += score
            if mid <= cur_sum:
                group_cnt += 1
                cur_sum = 0
        if K < group_cnt:
            l = mid + 1
        else:
            h = mid - 1
    print(l - 1)


if __name__ == "__main__":
    N, K = map(int, input().split())
    scores = list(map(int, input().split()))
    solution()

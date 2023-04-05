import sys

sys.setrecursionlimit(10 ** 6)
# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초	128 MB

[입력]
1> LCD창에 쓰여 있는 문자열 S (S는 길이는 50보다 작거나 같으)
=> 문자열 S에 쓰여 있는 문자를 알파벳 순서대로 출력하고자 할 때, 키를 누르는 횟수의 최솟값

[문제]
LCD창에는 문자열 S가 쓰여 있다. 
커서는 문자열의 가장 왼쪽 글자에 위치
버튼 세 개는 왼쪽, 오른쪽, 엔터키

엔터키는 문자열을 컴퓨터에 전송해서 컴퓨터 화면에 출력하는 역할
문자열이 화면에 출력되면, 그 문자는 빈 칸으로 변함

[예제]
aaa => ERERE
ba => RELE
abba => ERRRELELE
acbbc => ERRERERELLLE

sol) 그리디?
고른 문자로부터 가장 가까운 다음 문자를 택한다 => 항상 최적은 아님

sol) dp..
우선 엔터는 알파벳 글자수만큼 눌러야함 => 따져야하는건 방향키
같은 알파벳을 선택할때는 지그재그로 선택하지 않고 한 방향을 택하는 것이 나음 (어짜피 가장 먼 알파벳도 출력하기위해 도달해야하므로)

dp[i][j] : i번째 알파벳이 j번째 커서에 있을 때의 키 입력 최솟값
1. 현재 커서에서 방문해야하는 알파벳의 최소인덱스부터 방문하고 최대인덱스로 갈때 눌러야할 방향키의 수 + 엔터 수(해당 알파벳의 개수)
2. 현재 커서에서 방문해야하는 알파벳의 최대인덱스부터 방문하고 최소인덱스로 갈때 눌러야할 방향키의 수 + 엔터 수(해당 알파벳의 개수)
의 최솟값으로 정의할 수 있음

이전에 어떻게 이동했는지에 따라 뒤의 결과가 달라지므로 재귀 + dp로 구현
"""


def solution():
    def dfs(now: int, cursor: int) -> int:
        if now == 26:
            return 0

        if dp[now][cursor] != -1:
            return dp[now][cursor]

        dp[now][cursor] = sys.maxsize
        if alpha_cnt[now] > 0:
            l, h = low_idx[now], high_idx[now]
            dp[now][cursor] = min(dp[now][cursor], dfs(now + 1, h) + abs(cursor - l) + abs(l - h) + alpha_cnt[now])
            dp[now][cursor] = min(dp[now][cursor], dfs(now + 1, l) + abs(cursor - h) + abs(h - l) + alpha_cnt[now])
        else:
            dp[now][cursor] = min(dp[now][cursor], dfs(now + 1, cursor))

        return dp[now][cursor]

    for i in range(len(s)):
        idx = ord(s[i]) - ord('a')
        alpha_cnt[idx] += 1
        low_idx[idx] = min(low_idx[idx], i)
        high_idx[idx] = max(high_idx[idx], i)

    print(dfs(0, 0))


if __name__ == "__main__":
    s = input().strip()
    alpha_cnt = [0 for _ in range(26)]
    low_idx = [sys.maxsize for _ in range(26)]
    high_idx = [-1 for _ in range(26)]
    dp = [[-1 for _ in range(len(s))] for _ in range(26)]
    solution()

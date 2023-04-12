import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	128 MB

[입력]
1> N (2 이상 200 이하)
N> 1부터 N까지의 숫자
=> 첫째 줄에는 번호 순서대로 줄을 세우는데 옮겨지는 아이들의 최소 수

다시 번호 순서대로 줄을 세우기 위해서 아이들의 위치를 옮기
혼란스러워하지 않도록 하기 위해 위치를 옮기는 아이들의 수를 최소

sol) 
뒤에있는 아이를 앞으로 가져오면 뒤의 아이들은 순서가 하나씩 밀림
연속적으로 순서가 맞는 아이들이 있다면 나머지만 끼워 맞춰주면 될듯?
"""

def solution():
    ans = 1
    for i in range(N):
        dp[i] = 1
        for j in range(i+1):
            if children[j] < children[i]:
                dp[i] = max(dp[i], dp[j]+1)
        ans = max(ans, dp[i])
    print(N-ans)

if __name__ == "__main__":
    N = int(input())
    children = [int(input()) for _ in range(N)]
    dp = [0 for _ in range(N)]
    solution()
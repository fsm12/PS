import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
lcs dp 생성시 문자열을 넣으면 시간초과
lcs 배열을 만들고 역추적해서 문자열을 만들자
"""

def solution():
    for i in range(1, len(s1)+1):
        for j in range(1, len(s2)+1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    ansPoint = dp[len(s1)][len(s2)]
    print(ansPoint)

    
    ans = ['' for _ in range(ansPoint)]
    ansPoint -= 1
    i = len(s1)
    j = len(s2)
    while i>0 and j>0:
        if dp[i][j] == dp[i][j-1]:
            j-=1
        elif dp[i][j] == dp[i-1][j]:
            i-=1
        else:
            ans[ansPoint] = s1[i-1]
            ansPoint -= 1
            i-=1
            j-=1

    print(''.join(ans))

    
if __name__ == "__main__":
    s1 = list(input().strip())
    s2 = list(input().strip())
    dp = [[0 for _ in range(len(s2)+1)] for _ in range(len(s1)+1)]
    solution()
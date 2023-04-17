import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	256 MB

[입력]
1> 어린이 수
1> 처음에 줄서있는 어린이들의 번호 (어린이 수는 1이상 1,000,000이하의 정수, 1부터 N까지의 정수)
=> 번호순서대로 줄을 세우기 위해 제일 앞이나 제일 뒤로 보내는 어린이 수의 최솟값을 출력

줄 서있는 어린이 중 한 명을 선택하여 제일 앞이나 제일 뒤
어린이가 이동해서 빈자리가 생기는 경우에는 빈자리의 뒤에 있는 어린이들이 한 걸음씩 앞으로 걸어와서 빈자리를 메꿈

작은값은 앞으로, 큰값은 뒤로

sol) dp?
증가수열에 포함하는 번호는 고정한 채 나머지 번호만 움직이면 됨
"""

def solution():
    dp = [0 for _ in range(N+1)]
    for n in range(N):
        dp[inp[n]] = dp[inp[n]-1] + 1
    dp.sort()
    print(N-dp[N])

if __name__ == "__main__":
    N = int(input())
    inp = list(map(int, input().split()))
    solution()
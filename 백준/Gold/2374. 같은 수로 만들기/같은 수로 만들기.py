import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
그리디 

sol)
arr[n] < arr[n+1] : arr[n+1] - arr[n]
arr[n] > arr[n+1] : arr[n] - arr[n+1], arr[n+1]과 이후값들이 같으면 변화없음
5 4 3 3 4

sol)
스택에 최근에 들어온 값보다 큰값이 있다면 차이만큼 더해줌
스택에 남은 가장 큰수 * 스택 크기 - 스택의 총합 => 연산 횟수
"""


def solution():
    stack = [int(input())]
    ans, max_ = 0, stack[-1]

    for _ in range(N - 1):
        num = int(input())
        if stack[-1] < num:
            ans += num - stack[-1]
            max_ = max(max_, num)
        stack.pop()
        stack.append(num)
    ans += max_ * len(stack) - sum(stack)
    print(ans)


if __name__ == "__main__":
    N = int(input())
    solution()

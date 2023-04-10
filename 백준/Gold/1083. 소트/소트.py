import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초	128 MB

[입력]
1> N (50보다 작거나 같은 자연수)
1> 각 원소가 차례대로 (1000000보다 작거나 같은 자연수)
1> S (1000000보다 작거나 같은 음이 아닌 정수)

연속된 두 개의 원소만 교환
교환은 많아봐야 S번
소트한 결과가 사전순으로 가장 뒷서는 것을 출력??
=> 만들 수 있는 가장 큰수라고 생각하는게 좋을듯하다..

sol) 그리디?
가장 앞자리의 수가 클수록 큰수임 
S 범위내에서 가장 큰수를 가져올 수 있으면 앞으로 가져오고 그 이후의 과정을 차례대로 반복
"""

def solution():
    global S
    # 숫자들을 처음부터 보면서
    for n in range(N):
        max_val, max_idx = arr[n], n

        # S범위내에서 이동가능한 영역 중 가장 큰값을 찾아 갱신
        for i in range(n + 1, n + S + 1):
            # 문자열의 끝까지 왔다면 break
            if i == N:
                break
            if max_val < arr[i]:
                max_val, max_idx = arr[i], i

        # 찾은 최댓값이 원하는 자리에 없다면
        if max_idx != N:
            # 스위칭 작업을 통해 자리 이동 및 S값 갱신
            for i in range(max_idx, n, -1):
                arr[i] = arr[i - 1]
            arr[n] = max_val
            S -= (max_idx - n)

        if S == 0:
            break

    print(*arr)


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    S = int(input())
    solution()

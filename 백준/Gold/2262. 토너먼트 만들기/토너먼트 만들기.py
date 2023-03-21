import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
2 초	128 MB

[입력]
1> n (1 ≤ n ≤ 256)
1> n명의 선수들의 랭킹 (랭킹이 같은 경우는 없다)
=> 각 시합에 임하는 두 선수의 랭킹 차이의 총 합의 최솟값

랭킹이 높은 사람이 반드시 이김
=> 부전승을 여러 번 만들더라도 각 시합에 임하는 선수들의 랭킹 차이를 비슷하게 만들려고 한다.
토너먼트가 꼬여서는 안 된다. ?

sol)
랭킹의 차이가 가장 최소인 아이부터 꺼내기
PQ로 진행 => 어디선가 꼬이는듯..
리스트로 풀자
"""

def solution():
    maxNum = N
    ans = 0
    for n in range(N - 1):
        idx = arr.index(maxNum)
        if idx == 0:
            ans += abs(arr[idx] - arr[idx + 1])
        elif idx == len(arr) - 1:
            ans += abs(arr[idx - 1] - arr[idx])
        else:
            ans += min(abs(arr[idx - 1] - arr[idx]), abs(arr[idx] - arr[idx + 1]))
        arr.remove(arr[idx])
        maxNum -= 1
    print(ans)


if __name__ == "__main__":
    N = int(input())
    arr = list(map(int, input().split()))
    solution()

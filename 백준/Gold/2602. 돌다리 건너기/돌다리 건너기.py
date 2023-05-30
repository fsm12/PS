import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
뒤에서부터 탐색하면서 가능한 경우를 합해줌
"""


def solution():
    def jump(arr, type_, i, j):
        global ans
        # 배열 복사
        cur_arr = ""
        if arr == devil:
            cur_arr = angel
        else:
            cur_arr = devil
            
        cnt = 0
        # 같으면
        if inp[i] == arr[j]:
            # 앞에서 같은 값이 있는지 확인하고
            for k in range(j - 1, -1, -1):
                # 있으면 카운팅
                if cur_arr[k] == inp[i - 1]:
                    cnt += dp[type_][k]

            # 다른 돌다리에 값을 합쳐줌
            if type_ == 0:
                dp[1][j] = cnt
            else:
                dp[0][j] = cnt

            # 마지막이면 ans에 누적
            if i == len(inp) - 1:
                ans += cnt

    for i in range(1, len(inp)):
        for j in range(len(devil) - 1, -1, -1):
            jump(angel, 1, i, j)
            jump(devil, 0, i, j)

    print(ans)

if __name__ == "__main__":
    inp = [""] + list(input().strip())
    angel = [""] + list(input().strip())
    devil = [""] + list(input().strip())
    
    dp = [[0 for _ in range(len(angel))] for _ in range(2)]
    dp[0][0], dp[1][0] = 1, 1
    ans = 0
    solution()
import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
어떤 친구가 준 선물의 가격이 다른 친구가 준 선물의 가격과 D 이상 차이 나면 더 낮은 가격의 선물을 준 친구가 미안함을 느낌
MAX_PRICE - MIN_PRICE < D 를 만족해야함

sol) 가격순 정렬
투포인터로 영역을 확장해 나가면서 가능 범위를 찾기
"""

def solution():
    if N == 1:
        print(pv[0][1])
        return
    
    pv.sort(key=lambda x: x[0])

    sp, ep, ans, cur_sum = 0, 0, 0, 0
    while sp <= ep:
        if pv[ep][0] - pv[sp][0] < D:
            cur_sum += pv[ep][1]
            ep += 1
            ans = max(ans, cur_sum)
            if N <= ep:
                break
        else:
            cur_sum -= pv[sp][1]
            sp += 1
            if N <= sp:
                break
    print(ans)


if __name__ == "__main__":
    N, D = map(int, input().split())
    pv = [tuple(map(int, input().split())) for _ in range(N)]
    solution()

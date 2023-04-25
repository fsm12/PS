import sys
import math

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	512 MB

1> 격자의 크기 N (3 ≤ N ≤ 499, N은 홀수)
N> 격자의 각 칸에 있는 모래
=> 격자의 밖으로 나간 모래의 양을 출력

그대로 구현
"""

# 좌표 이동
def move():
    ans, cur_move, d = 0, 1, 0
    cx, cy = N // 2, N // 2
    while True:
        # 토네이도의 이동 특징은 같은 길이 만큼 두번 반복하고 길이가 증가 하는 형태
        for _ in range(2):
            x, y = dx[d], dy[d]
            for _ in range(cur_move):
                cx += x
                cy += y
                total_cnt = board[cx][cy]

                board[cx][cy] = 0
                if cx<0 or cy<0:
                    return ans
                ans += tornado(cx, cy, d, total_cnt)
            d = (d+1) % 4
        cur_move += 1

# 토네이도 이동
def tornado(x, y, d, total_cnt):
    alpha, out_amount = total_cnt, 0

    # 해당 방향의 딕셔너리 가져옴
    dic = rate[d]
    for r in dic.keys():
        # 비율만큼 모래양 계산
        sand = math.floor(total_cnt * r)
        if sand:
            for cx, cy in dic[r]:
                nx, ny = x + cx, y + cy
                # 모래가 존재하고 맵안이면 갱신, 맵밖이면 나간 모래양에 추가
                if 0 <= ny < N and 0 <= nx < N:
                    board[nx][ny] += sand
                else:
                    out_amount += sand
                alpha -= sand
    # 비율대로 다 나눠주고 남은 값도 추가해줌
    if alpha:
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < N and 0 <= ny < N:
            board[nx][ny] += alpha
        else:
            out_amount += alpha
    return out_amount


if __name__ == "__main__":
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    # 좌하우상
    dx, dy = (0, 1, 0, -1), (-1, 0, 1, 0)
    # 비율을 Key로 좌표를 value로 가지는 딕셔너리들을 생성
    rate = [
        {0.01: [(-1, 1), (1, 1)],
         0.02: [(2, 0), (-2, 0)],
         0.05: [(0, -2)],
         0.07: [(-1, 0), (1, 0)],
         0.1: [(-1, -1), (1, -1)]
         },
        {0.01: [(-1, -1), (-1, 1)],
         0.02: [(0, -2), (0, 2)],
         0.05: [(2, 0)],
         0.07: [(0, -1), (0, 1)],
         0.1: [(1, -1), (1, 1)]
         },
        {0.01: [(-1, -1), (1, -1)],
         0.02: [(2, 0), (-2, 0)],
         0.05: [(0, 2)],
         0.07: [(-1, 0), (1, 0)],
         0.1: [(-1, 1), (1, 1)]
         },
        {0.01: [(1, 1), (1, -1)],
         0.02: [(0, -2), (0, 2)],
         0.05: [(-2, 0)],
         0.07: [(0, -1), (0, 1)],
         0.1: [(-1, -1), (-1, 1)]
         }
    ]
    print(move())

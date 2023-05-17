import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
자기 공보다 크기가 작고 색이 다른 공을 사로잡아 그 공의 크기만큼의 점수 얻기
=>  i번째 공을 가진 플레이어가 잡을 수 있는 모든 공들의 크기 합

정렬, 누적합?
크기순, 색깔순으로 정렬
상대적으로 큰 크기의 공은 앞에 작았던 크기의 공의 점수를 얻을 수 있음

"""

def solution():
    balls.sort(key=lambda x: (x[1], x[0]))
    sum_list = [0 for _ in range(N + 1)]
    s, j = 0, 0
    for i in range(N):
        while balls[j][1] < balls[i][1]:
            sum_list[balls[j][0]] += balls[j][1]
            s += balls[j][1]
            j += 1
        ans[balls[i][2]] = s - sum_list[balls[i][0]]
        
    for i in ans:
        print(i)

if __name__ == "__main__":
    N = int(input())
    balls = []
    for n in range(N):
        C, S = map(int, input().split())
        balls.append((C, S, n))
    ans = [0 for _ in range(N)]
    solution()

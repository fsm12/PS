import sys
import heapq

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	256 MB

[입력]
1> N (1 ≤ N ≤ 1,000)
N> d : 과제 마감일까지 남은 일수(1 ≤ d ≤ 1,000) w : 과제의 점수 (1 ≤ w ≤ 100)
=> 얻을 수 있는 점수의 최댓값

sol) 우선순위 큐
1st 점수가 높은 아이부터, 2nd 마감일이 안타까운 아이부터 
"""

def solution():
    pq = []
    maxDay = 0
    for n in range(N):
        d, w = map(int, input().split())
        heapq.heappush(pq, (-w, d))
        maxDay = max(maxDay, d)

    ans = 0
    days = [False for _ in range(maxDay+1)]
    while pq:
        w, d = heapq.heappop(pq)
        for curDay in range(d, 0, -1):
            if not days[curDay]:
                days[curDay] = True
                ans -= w
                break
    print(ans)

if __name__ == "__main__":
    N = int(input())
    solution()
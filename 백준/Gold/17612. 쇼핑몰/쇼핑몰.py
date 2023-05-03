import heapq
import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
계산 빨리 끝 -> 번호가 작은 계산대 -> 출구에 가까운 번호 계산대(높은 수)
우선순위 큐 
"""

def solution():
    h = []
    for k in range(K):
        heapq.heappush(h, (0, k))

    finish = []
    for n in range(N):
        time, counter_id = heapq.heappop(h)
        t[counter_id] += w[n]
        heapq.heappush(h, (t[counter_id], counter_id))
        finish.append((t[counter_id], -counter_id, n))

    print(sum(id_[e[2]] * (seq + 1) for seq, e in enumerate(sorted(finish))))


if __name__ == "__main__":
    N, K = map(int, input().split())
    id_, w, t = [], [], [0 for _ in range(K)]
    for _ in range(N):
        aa, bb = map(int, input().split())
        id_.append(aa)
        w.append(bb)
    solution()

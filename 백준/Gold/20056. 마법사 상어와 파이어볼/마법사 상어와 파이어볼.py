import sys
from collections import deque

# sys.stdin = open("input.txt")
input = sys.stdin.readline

"""
1 초	512 MB

[입력]
1> N(4 ≤ N ≤ 50), M(0 ≤ M ≤ N^2), i(1 ≤ i ≤ 1,000)
M> 파이어볼의 정보가 한 줄(ri, ci, mi, si, di)
		i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si
		두 파이어볼의 위치가 같은 경우는 입력으로 주어지지 않는다.
=> 마법사 상어가 이동을 K번 명령한 후, 남아있는 파이어볼 질량의 합

마법사 상어가 크기가 N×N인 격자에 파이어볼 M개를 발사
1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결

마법사 상어가 모든 파이어볼에게 이동을 명령

1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동
	이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.

2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서
	같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
	파이어볼은 4개의 파이어볼로 
		[질량 :(합쳐진 파이어볼 질량의 합)/5
		, 속력 :(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)
		, 방향이 모두 홀 or 짝 => 방향은 0, 2, 4, 6, 그렇지 않으면 1, 3, 5, 7]
		질량이 0인 파이어볼은 소멸되어 없어진
"""

def solution():
    for _ in range(K):
        # 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동
        while fireballs:
            r, c, m, s, d = fireballs.pop()
            nr = (N + r + dr[d] * (s % N)) % N
            nc = (N + c + dc[d] * (s % N)) % N
            board[nr][nc].append((m, s, d))

        # 2. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다
        for r in range(N):
            for c in range(N):
                if len(board[r][c]) >= 2:
                    m_sum, s_sum, odd, even, size = 0, 0, 0, 0, len(board[r][c])

                    while board[r][c]:
                        mi, si, di = board[r][c].popleft()
                        m_sum += mi
                        s_sum += si

                        if di % 2 == 0:
                            odd += 1
                        else:
                            even += 1

                    nm, ns = m_sum // 5, s_sum // size
                    if nm == 0:
                        continue

                    if odd == size or even == size:
                        for i in range(0, 8, 2):
                            fireballs.append((r, c, nm, ns, i))
                    else:
                        for i in range(1, 8, 2):
                            fireballs.append((r, c, nm, ns, i))

                if len(board[r][c]) == 1:
                    m, s, d = board[r][c].popleft()
                    fireballs.append((r, c, m, s, d))

    print(sum([fb[2] for fb in fireballs]))


if __name__ == "__main__":
    N, M, K = map(int, input().split())
    fireballs = []
    for _ in range(M):
        r, c, m, s, d = list(map(int, input().split()))
        fireballs.append((r - 1, c - 1, m, s, d))
    board = [[deque() for _ in range(N)] for _ in range(N)]
    dr, dc = (-1, -1, 0, 1, 1, 1, 0, -1), (0, 1, 1, 1, 0, -1, -1, -1)
    solution()
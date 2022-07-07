N, M = map(int, input().split())
ori = []
cnt = []

for _ in range(N):
    ori.append(input())

for a in range(N-7):
    for b in range(M-7):
        idx1 = 0
        idx2 = 0
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j) % 2 == 0:
                    if ori[i][j] != 'W':
                        idx1 += 1
                    if ori[i][j] != 'B':
                        idx2 += 1
                else:
                    if ori[i][j] != 'B':
                        idx1 += 1
                    if ori[i][j] != 'W':
                        idx2 += 1
        cnt.append(min(idx1, idx2))
print(min(cnt))
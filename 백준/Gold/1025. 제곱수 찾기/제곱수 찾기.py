import math
import sys

NM = sys.stdin.readline().split()
N = int(NM[0])
M = int(NM[1])
ans = -1

graph = [[0 for _ in range(M)]for _ in range(N)]
for n in range(N):
	ent = sys.stdin.readline()
	for m in range(M):
		graph[n][m] = int(ent[m])

def slv(r, c):
	for i in range(-N,N):
		for j in range(-M,M):
			if(i==0 and j==0):
				continue

			global ans
			x=r
			y=c
			sqr=0

			while 0<=x<N and 0<=y<M:
				sqr *= 10
				sqr += graph[x][y]
				if math.sqrt(sqr)-int(math.sqrt(sqr))==0:
					ans = ans if ans>sqr else sqr

				x+=i
				y+=j

for n in range(N):
	for m in range(M):
		slv(n,m)

print(ans)
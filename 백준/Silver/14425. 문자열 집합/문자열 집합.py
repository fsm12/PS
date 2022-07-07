import sys
input = sys.stdin.readline

a,b=map(int,input().split())
al=[input() for _ in range(a)]
cnt=0
for _ in range(b):
    t = input()
    if t in al:
        cnt += 1
print(cnt)
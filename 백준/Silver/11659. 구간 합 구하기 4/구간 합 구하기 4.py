import sys
input=sys.stdin.readline
n,m=map(int,input().split())
l=list(map(int, input().split()))[:n]
sumArr=[0]*(n+1)
sumArr[1]=l[0]
for i in range(1, n):
    sumArr[i+1]=sumArr[i]+l[i]
for i in range(m):
    a,b=map(int,input().split())
    print(sumArr[b]-sumArr[a-1])
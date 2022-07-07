import sys
input = sys.stdin.readline
n=int(input())
a=[]
for i in range(n):
    x, y = map(int, input().split())
    a.append([y,x])
a.sort(key= lambda x: (x[0],x[1]))
for i in range(n):
    print(a[i][1], a[i][0])
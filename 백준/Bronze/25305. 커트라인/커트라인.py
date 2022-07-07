n,m=map(int,input().split())
l=list(map(int, input().split()))[:n]
for i in range(m-1):
    del l[l.index(max(l))]
print(max(l))
import math
n=int(input())
l=list(map(int,input().split()))[:n]
for i in l[1:]:
    v=math.gcd(l[0],i)
    print(l[0]//v,end="/")
    print(i//v)
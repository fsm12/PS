from itertools import combinations
a,b=map(int,input().split())
l=list(map(int,input().split()))[0:a]
max=0
for i in list(combinations(l,3)):
    s=i[0]+i[1]+i[2]
    if s<=b and max<=s:
        max=s
print(max)
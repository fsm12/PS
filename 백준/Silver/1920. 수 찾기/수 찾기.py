import sys
input=sys.stdin.readline

n=int(input())
nl=sorted(list(map(int,input().split()))[:n])
m=int(input())
ml=list(map(int,input().split()))[:m]

def binary(l,nl,st,end):
    if st>end:
        return 0
    m=(st+end)//2
    if l==nl[m]:
        return 1
    elif l<nl[m]:
        return binary(l,nl,st,m-1)
    else:
        return binary(l,nl,m+1,end)

for i in ml:
    st=0
    end=len(nl)-1
    print(binary(i,nl,st,end))
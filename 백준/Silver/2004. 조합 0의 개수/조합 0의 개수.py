def funCnt(n,k):
    cnt=0
    while k!=0:
        k//=n
        cnt+=k
    return cnt

import sys
input=sys.stdin.readline
n,m=map(int,input().split())

if m == 0:
    print(0)  
else:       
    print(min(funCnt(2,n)-funCnt(2,m)-funCnt(2,n-m), funCnt(5,n)-funCnt(5,m)-funCnt(5,n-m)))
    
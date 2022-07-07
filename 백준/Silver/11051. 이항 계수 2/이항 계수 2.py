import sys
input=sys.stdin.readline
n,k=map(int,input().split())
N,K=1,1
k=n-k if n//2<k else k
for i in range(n,n-k,-1):
    N*=i
    K*=(k-n+i)
print((N//K)%10007)
m,n=map(int,input().split())
prime=[True]*(n+1)
prime[0]=False
prime[1]=False
for a in range(len(prime)):
    if prime[a]:
        for b in range(a*2, n+1, a):
            prime[b]=False
for i in range(m,n+1):
    if prime[i]==True:
        print(i)
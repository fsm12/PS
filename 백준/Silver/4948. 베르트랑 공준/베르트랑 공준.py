while True:
    n=int(input())
    cnt=0
    if n==0:
        break
    prime=[True]*(2*n+1)
    prime[0]=False
    prime[1]=False
    for a in range(len(prime)):
        if prime[a]:
            for b in range(a*2, 2*n+1, a):
                prime[b]=False                
    for i in range(n+1, 2*n+1):
        if prime[i]==True:
            cnt+=1
    print(cnt)
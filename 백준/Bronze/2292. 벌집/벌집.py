n=int(input())
sum=1
for i in range(1,n+1):
    if sum>=n or n==1:
        print(i)
        break
    sum+=6*i
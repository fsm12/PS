n=int(input())
dp=[0]*n
l = list(map(int, input().split()))

dp[0]=l[0]
for i in range(1,n):
    dp[i]=max(dp[i-1]+l[i], l[i])
print(max(dp))
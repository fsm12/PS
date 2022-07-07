import sys
input=sys.stdin.readline

N, M = map(int,input().split())
nums = list(map(int,input().split()))

l = [0 for i in range(M)]
pre_sum = 0

l[0] = 1

for i in range(N):
    pre_sum+=nums[i]
    l[pre_sum%M] += 1
ans=0
for i in l:
    ans += i*(i-1)//2

print(ans)
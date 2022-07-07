n=int(input())
nums=[0]*(n+2)
nums[1]=1
nums[2]=2
for i in range(3, n+1):
    nums[i]=(nums[i-1]+nums[i-2])%15746
print(nums[n])
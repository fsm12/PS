for i in range(int(input())):
    n=int(input())
    nums=[0]*101
    nums[1]=1;nums[2]=1;nums[3]=1;nums[4]=2;nums[5]=2
    for i in range(5, n+1):
        nums[i]=nums[i-5]+nums[i-1] if nums[i]==0 else nums[i]
    print(nums[n])
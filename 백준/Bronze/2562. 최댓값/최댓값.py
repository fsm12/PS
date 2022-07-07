nums = list(int(input()) for _ in range(9))
index = nums.index(max(nums)) + 1
print(str(max(nums))+"\n"+str(index))
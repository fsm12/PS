nums = list(int(input()) for _ in range(3))
for i in range(10):
    print(str(nums[0]*nums[1]*nums[2]).count(str(i)))
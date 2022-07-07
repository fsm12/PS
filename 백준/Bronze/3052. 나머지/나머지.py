nums = list(int(input()) for _ in range(10))
rest = [nums[0]%42]
for i in nums:
    cnt=0
    for j in range(len(rest)):
        if rest[j]==i%42:
            break
        cnt+=1
        if len(rest)==j+1:
            rest.append(i%42)
print(len(rest))
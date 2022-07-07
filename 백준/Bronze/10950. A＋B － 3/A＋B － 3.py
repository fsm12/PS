aNums=[]
bNums=[]
num=int(input())
for i in range(num):
    a, b = input().split()
    aNums.append(int(a))
    bNums.append(int(b))

for j in range(num):
    print(aNums[j]+bNums[j])

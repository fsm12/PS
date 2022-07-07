import sys
n = int(sys.stdin.readline().strip())
getNum = set(map(int,sys.stdin.readline().split()))
m = int(sys.stdin.readline().strip())
checkNum = list(map(int,sys.stdin.readline().split()))
for i in checkNum:
    if i in getNum:
        print(1)
    else:
        print(0)
import sys
arr=[int(sys.stdin.readline().rstrip()) for i in range(int(input()))]
arr.sort()
for i in arr:
    sys.stdout.write(str(i)+'\n')
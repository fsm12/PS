import sys
input = sys.stdin.readline

def binary_search(left, right, target):
    while left < right:
        mid = (left + right) // 2
        if lis[mid] < target:
            left = mid + 1
        else:
            right = mid

    return right

n = int(input())
port = list(map(int, input().split()))

lis = [port[0]]
for i in range(1, n):
    if lis[-1] < port[i]:
        lis.append(port[i])
    else:
        lower_bound = binary_search(0, len(lis)-1, port[i])
        lis[lower_bound] = port[i]
print(len(lis))
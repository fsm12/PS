n=int(input())
l=[int(input()) for _ in range(n)]
for i in range(n):
    print(sorted(l)[i])
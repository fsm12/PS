x=int(input())
total=0
for i in range(int(input())):
    a,b = map(int,input().split())
    total+=a*b
print("Yes" if total==x else "No")
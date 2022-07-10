l=list(map(int,input().split()))
total=0
for i in l:
    total+=i**2
print(total%10)
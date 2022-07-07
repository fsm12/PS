n=int(input())
l=list(map(int,input().split()))
cnt=0
for i in l[:n]:
    if i==1:
        continue
    ok=0
    for j in range(1,i+1):
        ok+=1 if i%j==0 else 0
    cnt+=1 if ok==2 else 0
print(cnt)
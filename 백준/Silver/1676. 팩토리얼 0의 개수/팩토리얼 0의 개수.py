n=int(input())
res=1
for i in range(n,1,-1):
    res*=i
l=list(str(res))
cnt=0
for i in range(len(l)-1,0,-1):
    if l[i]!="0":
        break
    else:
        cnt+=1
print(cnt)
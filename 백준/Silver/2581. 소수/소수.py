m,n=int(input()),int(input());num=m;l=[]
while num>=m and num<=n:
    ok=1
    if(num<2):
        ok=0
    for i in range(2,num):
        if(num%i==0):
            ok=0
    if ok==1:
        l.append(num)
    num+=1
print(-1 if not l else f"{sum(l)}\n{min(l)}")
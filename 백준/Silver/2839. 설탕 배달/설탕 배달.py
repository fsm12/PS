s=int(input());b=0;ok=0
while s>=0:
    if s%5 ==0:
        b+=(s//5)
        print(b)
        ok=1
        break
    s-=3
    b+=1
if ok==0:
    print(-1)
l=list(map(int,input().split()))
lcf=1;ok=0
minVal=min(l)
for i in range(2,minVal+1):
    while True:
        if l[0]%i==0 and l[1]%i==0:
            lcf*=i
            l[0]//=i
            l[1]//=i
        else:
            break
print(lcf)
print(lcf*l[0]*l[1])
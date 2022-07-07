n=input()
i='1'
while(int(i)<=int(n)):
    cur=int(i)+sum([int(j) for j in list(i)])
    if int(n)==cur:
        break
    i=str(int(i)+1)
print(0 if int(n)+1==int(i) else i)
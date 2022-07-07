a=[-1]*26
cnt=0
for i in list(input()):
    if a[ord(i)-97]==-1:
        a[ord(i)-97]= cnt
    cnt+=1
for i in a:
    print(i,end=" ")
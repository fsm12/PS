import sys
input=sys.stdin.readline

stack_list=["-"]*100001
pos=0
idx=0;total=0;ok=False
str=input()
for c in str:
    if c=='(':
        stack_list[pos]=c
        pos+=1;ok=True
    elif c==')':
        pos-=1
        total+=1
        if ok==True:
            total+=(pos-1)
        ok=False
print(total)

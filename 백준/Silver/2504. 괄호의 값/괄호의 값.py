import sys
input=sys.stdin.readline

stack=[False]*31
pos=0
st=input().rstrip()

ans=0;tmp=1;
for idx,e in enumerate(st):
    if e=='(':
        tmp*=2
        stack[pos]='('
        pos+=1
    elif e=='[':
        tmp*=3
        stack[pos]='['
        pos+=1
    elif e==')':
        if pos==0 or stack[pos-1]!='(':
            ans=0
            break
        if st[idx-1]=='(':
            ans+=tmp
            tmp//=2
            pos-=1
        else:
            tmp//=2
            pos-=1
    elif e==']':
        if pos==0 or stack[pos-1]!='[':
            ans=0
            break
        if st[idx-1]=='[':
            ans+=tmp
            tmp//=3
            pos-=1
        else:
            tmp//=3
            pos-=1
if pos!=0:
    ans=0
print(ans)

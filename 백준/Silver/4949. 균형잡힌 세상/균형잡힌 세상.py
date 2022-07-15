import sys
input=sys.stdin.readline

while(True):
    stack = ["-"] * 101
    pos = 0
    s=input().rstrip()
    if s == ".":
        break
    ok=True
    for c in s:
        if c=="(" or c=="[":
            stack[pos]=c
            pos+=1
        elif c==")":
            if pos==0 or stack[pos-1]!="(":
                ok=False
                break
            pos-=1
        elif c=="]":
            if pos==0 or stack[pos-1]!="[":
                ok=False
                break
            pos-=1
    if pos!=0:
        ok=False
    print("yes" if ok else "no")

N,M=map(int,input().split())
out=[]

def solve(start):
    if len(out)==M:
        print(' '.join(map(str,out)))
        return
    for i in range(1,N+1):
        if len(out)>0:
            if out[len(out)-1]>i:
                continue
        out.append(i)
        solve(i+1)
        out.pop()
solve(1)
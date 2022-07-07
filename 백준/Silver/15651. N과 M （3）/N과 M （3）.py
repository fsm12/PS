N,M=map(int,input().split())
out=[]

def solve(start):
    if len(out)==M:
        print(' '.join(map(str,out)))
        return
    for i in range(1,N+1):
        out.append(i)
        solve(i+1)
        out.pop()
solve(1)
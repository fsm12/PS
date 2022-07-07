def solve(depth, N, M):
    if depth==M:
        print(' '.join(map(str,out)))
        return
    else:
        for i in range(len(visited)):
            if not visited[i]:
                visited[i]=True
                out.append(i+1)
                solve(depth+1,N,M)
                visited[i]=False
                out.pop()

N,M=map(int,input().split())
visited=[False]*N
out=[]

solve(0,N,M)
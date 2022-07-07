import sys
N=int(sys.stdin.readline())            
row = [0] * N
res = 0   

def is_exist(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == x-i:
            return False 
    return True
 
def dfs(x):
    global res
    if x == N:
        res += 1
    else:
        for i in range(N): 
            row[x] = i
            if is_exist(x):
                dfs(x+1)
dfs(0)
print(res)
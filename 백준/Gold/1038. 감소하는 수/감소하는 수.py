from itertools import combinations

N = int(input()) 
ans = []

dataset = [i for i in range(10)]
for i in range(1, 11):
    tmp = list(map(list, combinations(dataset, i)))
        
    for j in range(len(tmp)):
        tmp[j] = sorted(tmp[j], reverse=True)
    
    for j in range(len(tmp)):
        ans.append(int(''.join(map(str, tmp[j]))))

ans.sort()

if N >= len(ans):
    print(-1)
else:
    print(ans[N])
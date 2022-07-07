all_n=int(input())
for i in range(all_n):
    scores=list(map(int, input().split()))
    
    n=scores[0]
    scores=scores[1:]
    
    res = [x for x in scores if x>(sum(scores)/n)]
    print(f"{len(res)/len(scores)*100:.3f}%")
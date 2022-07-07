n = int(input())
p_list = list(input() for _ in range(n))
for i in range(len(p_list)):
    x_idx = [j for j in range(len(p_list[i])) if p_list[i][j]=="X"]
    x_idx.append(len(p_list[i]))
    total=0

    start = -1
    for x in x_idx:
        cnt = x-start-1
        if cnt!=0:
            for j in range(1,cnt+1):
                total+=j
        start=x
    print(total)
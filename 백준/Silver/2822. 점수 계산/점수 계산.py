l=[]
for i in range(8):
    l.append(int(input()))
total_idx=[l.index(max(l))+1]
total_val=max(l)
for i in range(4):
    l[l.index(max(l))]=-1
    total_idx.append(l.index(max(l))+1)
    total_val+=max(l)
print(total_val)
print(" ".join(map(str, sorted(total_idx))))
st=input()
res=st[0]
l= [i for i, ele in enumerate(st) if ele == "-"]
for i in l:
    res+=st[i+1]
print(res)
n,m=map(int,input().split())
ans=[input() for _ in range(n)]
qes=[input() for _ in range(m)]

dic={}
for i,name in enumerate(ans):
  dic[i+1]=name
rev_dic={v:k for k,v in dic.items()}

for i in range(m):
  inp=qes[i]
  print(rev_dic[inp] if not inp.isnumeric() else dic[int(inp)])
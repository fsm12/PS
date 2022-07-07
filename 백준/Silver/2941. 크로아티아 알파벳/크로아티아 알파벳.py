l=['c=','c-','dz=','d-','lj','nj','s=','z=']
n=[0]*8
s=input()
for i in range(len(l)):
    n[i] = s.count(l[i])-n[2] if i==7 else s.count(l[i])

total=len(s)    
for i in range(len(l)):
    total-= 0 if n[i]==0 else (n[i] if i!=2 else n[i]*2)
print(total)
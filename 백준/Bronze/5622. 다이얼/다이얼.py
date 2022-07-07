n=['','ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ','']
s=input()
t=0
for i in range(len(n)):
    for j in s:
        if j in n[i]:
            t+=i+2
print(t)
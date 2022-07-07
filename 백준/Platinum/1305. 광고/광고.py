L=int(input())
s=input()

table=[0]*len(s)
j=0
for i in range(1,len(s)):
    while j>0 and s[i]!=s[j]:
        j=table[j-1]
    if s[i]==s[j]:
        j+=1
        table[i]=j
print(len(s)-table[len(s)-1])
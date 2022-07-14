s=input()
l=[0]*26
for ch in s:
    l[ord(ch)-97]+=1
print(" ".join(map(str,l)))
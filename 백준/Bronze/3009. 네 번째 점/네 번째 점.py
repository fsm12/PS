l=[]
for _ in range(3):
    l.extend(map(int,input().split()))
odd=l[0::2]
even=l[1::2]
print(min(odd) if odd.count(min(odd))==1 else max(odd), min(even) if even.count(min(even))==1 else max(even))
a,b=map(int,input().split())
a=set([input() for _ in range(a)])
b=set([input() for _ in range(b)])

l=sorted(list(a&b))
print(len(l))
for i in l:
    print(i)
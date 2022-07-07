a = input().upper()
b = list(set(a))
c = []

for i in b:
    cnt = a.count(i)
    c.append(cnt)

if c.count(max(c)) >= 2:
    print("?")
else:
    print(b[c.index(max(c))])
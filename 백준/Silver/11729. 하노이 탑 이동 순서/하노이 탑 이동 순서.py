def h(a,b,c):
    if (a==1):
        print(b,c)
    else:
        h(a-1, b, 6-b-c)
        print(b, c)
        h(a-1, 6-b-c, c)
a = int(input())
print(2**a-1)
h(a, 1, 3)
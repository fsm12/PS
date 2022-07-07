while True:
    l=list(map(int,input().split()))
    if l[0]==0 and l[1]==0 and l[2]==0:
        break
    m=max(l)
    l.remove(m)
    print("right" if m**2==l[0]**2+l[1]**2 else "wrong")
T=int(input())
for i in range(T):
    x1, y1, x2, y2 = map(int, input().split())
    res=0
    n=int(input())
    l=[]
    [l.append(list(map(int,input().split()))) for _ in range(n)]
    for j in range(n):
        x=l[j][0];y=l[j][1];r=l[j][2]
        s_dist = ((x1-x)**2+(y1-y)**2)**(1/2)
        e_dist = ((x2-x)**2+(y2-y)**2)**(1/2)
        se_dist = ((x1-x2)**2+(y1-y2)**2)**(1/2)
        res+=0 if s_dist<r and e_dist<r and se_dist<2*r else (1 if s_dist<r or e_dist<r else 0)
    print(res)
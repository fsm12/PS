import sys
input=sys.stdin.readline
for i in range(int(input())):
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    dist=((x1-x2)**2+(y1-y2)**2)**(1/2)
    print(-1 if dist==0 and r1==r2 and r1!=0 else (1 if (abs(r1-r2)==dist) or (r1+r2==dist) else (2 if abs(r1-r2)<dist<(r1+r2) else 0)))
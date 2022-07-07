width,height,x,y,pNum=map(int,input().split())
l=[];cnt=0
[l.append(list(map(int,input().split()))) for _ in range(pNum)]
for i in range(len(l)):
    tx=l[i][0];ty=l[i][1]
    left_r = ((x-tx)**2+(y+height/2-ty)**2)**(1/2)
    right_r = ((x+width-tx)**2+(y+height/2-ty)**2)**(1/2)
    if (tx<=x and left_r<=height/2) or (tx>=x+width and right_r<=height/2) or (x<=tx<=x+width and y<=ty<=y+height):
        cnt+=1
print(cnt)
n=int(input())
l=[list(map(int,input().split())) for _ in range(6)]
width=0;w=0
height=0;h=0
for i in range(len(l)):
    if l[i][0] == 1 or l[i][0] == 2:
        if width<l[i][1]:
            width=l[i][1]
            w=i
    elif l[i][0] == 3 or l[i][0] == 4:
        if height<l[i][1]:
            height=l[i][1]
            h=i
    W=abs(l[(w-1)%6][1] - l[(w+1)%6][1])
    H=abs(l[(h-1)%6][1] - l[(h+1)%6][1])
print(((width*height)-(W*H))*n)
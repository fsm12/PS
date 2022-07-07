import sys
input = sys.stdin.readline

l=[]
for i in range(int(input())):
    a,b=input().split()
    l.append([int(a),b])
l=sorted(l, key=lambda x:x[0])
for i in range(len(l)):
    print(l[i][0],l[i][1])
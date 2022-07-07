import sys
input=sys.stdin.readline

n=int(input())
l=list(map(int,input().split()))[:n]
sort_l=sorted(set(l))
l_dict={i:v for v,i in enumerate(sort_l)}
for i in l:
    print(f'{l_dict[i]}',end=" ")
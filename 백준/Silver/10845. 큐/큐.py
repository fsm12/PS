from collections import deque
import sys
input=sys.stdin.readline

queue = deque()
for i in range(int(input())):
    l=input().split()
    if l[0]=="push":
        queue.append(int(l[1]))
    elif l[0]=="pop":
        print(-1 if len(queue) == 0 else queue.popleft())
    elif l[0] == "size":
        print(len(queue))
    elif l[0] == "empty":
        print(1 if len(queue)==0 else 0)
    elif l[0] == "front":
        print(-1 if len(queue) == 0 else queue[0])
    else:
        print(-1 if len(queue) == 0 else queue[-1])

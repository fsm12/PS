from collections import deque
import sys
input=sys.stdin.readline

queue = deque()
for i in range(int(input())):
    l=input().split()
    if l[0] == "push_front":
        queue.appendleft(int(l[1]))
    elif l[0] == "push_back":
        queue.append(int(l[1]))
    elif l[0] == "pop_front":
        print(-1 if len(queue) == 0 else queue.popleft())
    elif l[0] == "pop_back":
        print(-1 if len(queue) == 0 else queue.pop())
    elif l[0] == "size":
        print(len(queue))
    elif l[0] == "empty":
        print(1 if len(queue) == 0 else 0)
    elif l[0] == "front":
        print(-1 if len(queue) == 0 else queue[0])
    else:
        print(-1 if len(queue) == 0 else queue[-1])

import sys
input=sys.stdin.readline

stack_list = [0] * 10001
pos = 0
for i in range(int(input())):
    s = list(input().split())
    if len(s) == 2:
        stack_list[pos] = int(s[1])
        pos += 1
    elif s[0] == "pop":
        if pos == 0:
            print(-1)
        else:
            print(stack_list[pos-1])
            pos -= 1
    elif s[0] == "size":
        print(pos)
    elif s[0] == "empty":
        print(1 if pos == 0 else 0)
    else:
        print(-1 if pos == 0 else stack_list[pos - 1])

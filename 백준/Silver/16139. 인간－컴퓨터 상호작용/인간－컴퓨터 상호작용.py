import sys
input = sys.stdin.readline

s = list(input())
n = int(input())
acc = []
li = [0] * 26

for c in s:
    if 97 <= ord(c) <= 122:
        li[ord(c) - 97] += 1
        acc.append(li[:])

for _ in range(n):
    c, s, e = input().split()
    ans = acc[int(e)][ord(c) - 97]
    if s != '0':
        ans -= acc[int(s) - 1][ord(c) - 97]
    print(ans)
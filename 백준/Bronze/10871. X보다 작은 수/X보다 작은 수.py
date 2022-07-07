a,b = map(int, input().split())
num_list = list(map(int, input().split()))
for i in range(a):
    if b>num_list[i]:
        print(num_list[i], end=" ")
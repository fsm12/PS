channel = int(input())
ans = abs(100 - channel)
N = int(input())
broken = set(input().split()) if N!=0 else set()

for num in range(1000001): 
    for _ in str(num):
        if _ in broken:
            break
    else:
        ans = min(ans, len(str(num)) + abs(num - channel))
print(ans)
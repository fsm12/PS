num = int(input())
res = num
ok = 0
cnt = 0
while num!=res or ok==0:
    cnt+=1
    res = res%10*10 + (res%10+res//10)%10
    ok+=1 if res==num else 0
print(cnt)
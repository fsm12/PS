import sys
input=sys.stdin.readline
plus_Num=0
xor_cal=0

for i in range(int(input())):
    st=input().split()
    if st[0]=="1":
        plus_Num+=int(st[1])
        xor_cal^=int(st[1])
    elif st[0]=="2":
        plus_Num-=int(st[1])
        xor_cal ^= int(st[1])
    elif st[0]=="3":
        print(plus_Num)
    else:
        print(xor_cal)
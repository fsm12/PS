a = int(input())
b=0
while a>0:
    b+=1
    a-=b
a+=b
b+=1
if b%2==0:
    print(f"{b-a}/{a}")
else:
    print(f"{a}/{b-a}")
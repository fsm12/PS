for i in range(int(input())):
    h,s=map(int,input().split())
    a,b=h,s

    if(a>b) : a,b = b,a
    while(b!=0):
        a=a%b
        a,b=b,a

    print(a*(h//a)*(s//a))
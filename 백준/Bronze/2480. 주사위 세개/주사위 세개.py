a,b,c=map(int, input().split())
print(10000+a*1000 if a==b==c else (1000+a*100 if a==b or a==c else (1000+b*100 if b==c else (a*100 if a>b and a>c else(b*100 if b>a and b>c else c*100)))))
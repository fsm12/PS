for i in range(int(input())):
    s=input()
    if len(s)%2==1:
        print("NO")
        continue
    while "()" in s:
        s=s.replace("()","")
    if len(s)==0:
        print("YES")
        continue
    print("NO")
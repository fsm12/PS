st=input()
while int(st):
    if st=="".join(list(reversed(st))):
        print("yes")
    else:
        print("no")
    st=input()
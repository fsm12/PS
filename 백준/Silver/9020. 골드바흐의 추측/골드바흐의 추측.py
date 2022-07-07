from sys import stdin

T=int(stdin.readline())

def prime(number): 
    if number<2:
        return False
    for j in range(2,int(number**0.5)+1):
        if number%j==0:
            return False
    return True

for i in range(T): 
    n=int(stdin.readline()) 
    a=int(n/2)
    b=int(n/2)

    for k in range(int(n/2)):
        if prime(a) and prime(b):
            print(a,b)
            break
        else:
            a=a-1
            b=b+1
arr=[False]*11
arr[1]=1
arr[2]=2
arr[3]=4
for i in range(int(input())):
    n=int(input())
    for j in range(4,n+1):
        if not arr[j]:
            arr[j]=arr[j-1]+arr[j-2]+arr[j-3]
    print(arr[n])
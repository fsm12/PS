t=int(input())
for i in range(t):
    category=[];dressCnt=[]
    for j in range(int(input())):
        a,b=input().split()
        ok=0;idx=0
        for k in range(len(category)):
            if category[k]==b:
                ok=1
                idx=k
                break
        if ok==0:
            category.append(b);dressCnt.append(1)
        else:
            dressCnt[k]+=1
    answer = 1
    for c in dressCnt:
        answer *= (c+1) 
    print(answer-1)  
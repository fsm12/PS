from itertools import combinations

N = int(input())
ans = []

dataset = [i for i in range(10)]
for i in range(1, 11):
    # 해당 자릿수 만큼 조합을 생성
    comb_list = list(map(list, combinations(dataset, i)))

    # 조합을 뽑으면 뒤로갈수록 커지는 식으로 생성되므로, 반대로 정렬하면 큰수가 앞에오도록 뽑을 수 있다 
    for j in range(len(comb_list)):
        comb_list[j] = sorted(comb_list[j], reverse=True)

    # 뽑은 숫자 한자리 들을 모아서 한 숫자로 만든뒤 append 연산 ex) [1,2,3,4] -> 1234
    for j in range(len(comb_list)):
        ans.append(int(''.join(map(str, comb_list[j]))))

# 정렬해야 커지는 순서대로 위치를 잡을 수 있으므로, 인덱스만으로 증가하는 수를 뽑을 수 있다.
ans.sort()
print(-1 if N >= len(ans) else ans[N])
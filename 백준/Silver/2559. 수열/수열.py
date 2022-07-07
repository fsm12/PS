n,m = map(int, input().split())
tem_list = list(map(int, input().split()))

part_sum = sum(tem_list[:m])
result_list = [part_sum]

for i in range(0, len(tem_list)-m):
    part_sum = part_sum - tem_list[i] + tem_list[i+m]
    result_list.append(part_sum)

print(max(result_list))
word_list = []
for i in range(int(input())):
    word_list.append(input())

word_list = list(set(word_list))
word_list.sort()
word_list.sort(key = lambda x : len(x))

for word in word_list:
    print(word)
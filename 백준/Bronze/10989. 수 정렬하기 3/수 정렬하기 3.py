from sys import stdin

input = stdin.readline().strip
N = int(input())
numbers = []
for i in range(10001):
  numbers.append(0)

for i in range(N):
  numbers[int(stdin.readline().rstrip())] += 1

for index, count in enumerate(numbers):
  if count != 0:
    for _ in range(count):
      print(index)
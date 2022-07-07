A, B = map(int, input().split())
C = int(input()) 
minute = B+C
hour = (A + minute//60)%24
minute = minute%60
print(hour, minute)
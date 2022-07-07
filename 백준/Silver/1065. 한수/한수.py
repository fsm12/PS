def num(n):
    ans = 0
    for i in range (1, n+1): 
        if i<100: 
            ans += 1
        else:
            strN = str(i)
            if int(strN[0]) + int(strN[2]) == (int(strN[1]))*2:
                ans += 1
    return ans
print(num(int(input())))
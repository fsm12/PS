def stars(n):
    if n==1:
        return ['*']

    s_list=stars(n//3)
    l=[]

    for star in s_list:
        l.append(star*3)
    for star in s_list:
        l.append(star+' '*(n//3)+star)
    for star in s_list:
        l.append(star*3)
    return l

n=int(input())
print('\n'.join(stars(n)))
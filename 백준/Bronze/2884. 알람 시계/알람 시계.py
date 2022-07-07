h, m = map(int, input().split())
print(str(h)+" "+str(m-45) if m>=45 and h!=0 else (str(h)+" "+str(m-45) if m>=45 and h==0  else (str(h-1)+" "+str(m+15) if m<45 and h!=0 else "23 "+str(m+15))))
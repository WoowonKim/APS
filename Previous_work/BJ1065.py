N = input()
cnt = 0

for n in range(1,int(N)+1):    
    a= str(n)

    if n < 100:
        cnt += 1
        continue
    else:
        diff = int(a[0]) - int(a[1])
    
    for i in range(len(a)):
        try:
            next_diff = int(a[i]) - int(a[i+1])
        except:
            cnt += 1
            break

        if next_diff != diff:
            break

print(cnt)
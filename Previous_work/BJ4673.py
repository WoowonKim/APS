def get_dn(x):
    dn = x
    for i in str(x):
        dn += int(i)
    return dn
    
    
self_num = list(range(1,10001))

for idx in range(1,10000):
    a = get_dn(idx)
    try:
        self_num.remove(a)
    except:
        pass

for num in self_num:
    print(num)
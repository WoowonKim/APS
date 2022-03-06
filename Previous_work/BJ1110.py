from imp import new_module


N = int(input())

def get_digitsum(x):
    if x < 10:
        return x
    else:
        return x%10 + x//10
    

def get_newnum(a, b):
    new_num = (a%10)*10 + b%10
    return new_num


ans = 1
digitsum = get_digitsum(N)
newnum = get_newnum(N, digitsum)

while N != newnum:
    digitsum = get_digitsum(newnum)
    newnum = get_newnum(newnum, digitsum)
    ans += 1

print(ans)
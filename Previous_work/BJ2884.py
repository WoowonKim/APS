H, M = map(int,input().split())

if M < 45:
    if H == 0:
        H = 23
        M = M + 60 - 45
        print(f'{H} {M}')
    else:
        H -= 1
        M = M + 60 - 45
        print(f'{H} {M}')
else:
    M -= 45
    print(f'{H} {M}')
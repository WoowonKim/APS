A = int(input())
B = int(input())
C = int(input())

mul = str(A * B * C)

for i in range(10):
    idx = 0
    for x in mul:
        if int(x) == i:
            idx += 1
    print(idx)
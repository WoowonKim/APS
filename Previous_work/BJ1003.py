fibo0 = [1, 0, 1]
fibo1 = [0, 1, 1]
def fibo(N):
    if N >= len(fibo0):
        for i in range(len(fibo0), N+1):
            fibo0.append(fibo0[i-1] + fibo0[i-2])
            fibo1.append(fibo1[i-1] + fibo1[i-2])
    return print(f'{fibo0[N]} {fibo1[N]}')
T = int(input())

for i in range(T):
    N = int(input())
    fibo(N)
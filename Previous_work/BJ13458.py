cls = int(input())
cls_n = list(map(int,input().split()))
main_dir, sub_dir = map(int,input().split())

mdir_n = cls
sdir_n = 0

for i in range(cls):
    std_remain = cls_n[i] - main_dir
    if std_remain > 0:
        a = std_remain/sub_dir
        if a == int(a):
            sdir_n += a
        else:
            sdir_n += int(a) + 1

print(int(mdir_n + sdir_n))

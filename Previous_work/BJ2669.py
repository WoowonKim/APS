def get_area(vertex):
    unit = set()
    for i in vertex:
        x = range(i[0],i[2])
        y = range(i[1],i[3])
        for j in x:
            for k in y:
                unit.add((j,k))
    return unit       


T = []
for i in range(4):
    T.append(list(map(int,input().split())))

ans = get_area(T)
print(len(ans))
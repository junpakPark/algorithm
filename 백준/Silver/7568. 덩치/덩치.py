import sys
input = sys.stdin.readline

arr = [tuple(map(int, input().split())) for i in range(int(input()))]

for x1, y1 in arr:
    count = 1
    for x2, y2 in arr:
        if x1 < x2 and y1 < y2:
            count += 1
    print(count, end =' ')
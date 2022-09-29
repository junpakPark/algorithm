import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
time = sys.maxsize
height = 0

for num in range(257):
    max = min = 0

    for i in range(n):
        for j in range(m):

            if arr[i][j] >= num:
                max += arr[i][j] - num

            else:
                min += num - arr[i][j]

  
    if max + b >= min:
        if min + (max * 2) <= time:
            time = min + (max * 2) # 최저 시간
            height = num # 층수

print(time, height)
import sys
input = sys.stdin.readline

T = int(input())

arr = list(map(int, input().split()))

result = sorted(set(arr))

dic = {result[i] : i for i in range(len(result))}

for i in arr:
    print(dic[i], end = ' ')
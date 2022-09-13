import sys
input = sys.stdin.readline

T = int(input())

arr = list(map(int, input().split()))

result = list(set(arr))
result.sort()

dic = {result[i] : i for i in range(len(result))}

for i in range(T):
    print(dic[arr[i]], end = ' ')

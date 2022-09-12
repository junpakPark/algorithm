import sys
input = sys.stdin.readline

n = int(input())
arr =[]

for _ in range(n):
  arr.append(input())

result = list(set(arr))
result.sort()
result.sort(key = len)

print(*result, sep='')

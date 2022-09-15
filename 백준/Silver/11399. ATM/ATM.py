import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr.sort()
result = []

for i in range(n):
  result.append(sum(arr[:i+1]))

print(sum(result))
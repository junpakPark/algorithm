import sys
input = sys.stdin.readline

n = int(input())

arr = []

for _ in range(n):
  a,b = map(int, input().split())
  arr.append((a,b))

arr.sort()

for i in range(n):
  print(*arr[i])
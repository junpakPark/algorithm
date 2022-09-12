import sys
input = sys.stdin.readline

T = int(input())

arr = []

for _ in range(T):
  a, b = input().split()
  arr.append((int(a), b))

arr.sort(key = lambda x : x[0])

for i in range(T):
  print(*arr[i])
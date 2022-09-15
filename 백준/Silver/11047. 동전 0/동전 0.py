import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = []

for _ in range(n):
  a = int(input())
  if a <= k:
    arr.append(a)
  else:
    break

cnt = 0

for i in arr[::-1]:
  if k // i > 0:
    cnt += k//i
    k = k % i

print(cnt)
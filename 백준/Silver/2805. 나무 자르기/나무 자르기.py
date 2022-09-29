import sys
input = sys.stdin.readline


n, m = map(int, input().split())
arr = list(map(int, input().split()))

start, end = 1,  max(arr)

while start <= end:
  mid = (start + end) // 2
  num = 0

  for i in arr:
    if i >= mid:
      num += i - mid
  
  if num >= m:
      start = mid + 1
  else:
      end = mid -1
print(end)
import sys
from collections import Counter

input = sys.stdin.readline


T = int(input())

arr = []
for _ in range(T):
  arr.append(int(input()))

arr.sort()

# 산술평균
print(round(sum(arr)/T))

# 중앙값
print(arr[T//2])

# 최빈값
count = Counter(arr).most_common(2)
if len(count) > 1:
  if count[0][1] == count [1][1]:
    print(count[1][0])
  else:
    print(count[0][0])
else:
  print(count[0][0])

# 범위
print(arr[-1] - arr[0])
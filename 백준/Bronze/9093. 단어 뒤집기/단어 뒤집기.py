import sys
input = sys.stdin.readline

for _ in range(int(input())):
  arr = list(map(str, input().split()))
  result = []
  for i in arr:
    result.append(i[::-1])
  
  print(*result)
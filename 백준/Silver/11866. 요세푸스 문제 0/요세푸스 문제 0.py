import sys
from collections import deque

input = sys.stdin.readline

a, b = map(int, input().split())

arr= deque([i+1 for i in range(a)])
result = []

while arr:
  for i in range(b-1):
    arr.append(arr.popleft())
  result.append(arr.popleft())

print('<',', '.join(map(str, result)),'>', sep='')
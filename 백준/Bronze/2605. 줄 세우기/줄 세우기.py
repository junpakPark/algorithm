import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
front = []
back = []

for i in range(n):
  if arr[i] == 0:
    front.append(i+1)
  else:
    for j in range(arr[i]):
      back.append(front.pop())
    front.append(i+1)
    front += back[::-1]
    back = []

print(*front)
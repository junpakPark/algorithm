import sys
input = sys.stdin.readline

T = int(input())
arr = list(map(int, input().split()))

stack = []
result = [-1] * T
for i in range(T):
  while stack and arr[stack[-1]] < arr[i]:
    result[stack.pop()] = arr[i]
  stack.append(i)

print(*result)
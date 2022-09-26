import sys
input = sys.stdin.readline

arr = []
for _ in range(int(input())):
  a = int(input())
  if a != 0:
    arr.append(a)
  else:
    arr.pop()

print(sum(arr))
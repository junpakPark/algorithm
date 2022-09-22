import sys
input = sys.stdin.readline

arr = []

for _ in range(int(input())):
  n = input().split()

  if n[0] == 'push':
    arr.append(n[1])
  elif n[0] == 'pop':
    print(arr.pop() if len(arr) != 0 else -1)
  elif n[0] == 'size':
    print(len(arr))
  elif n[0] == 'empty':
    print(1 if len(arr) == 0 else 0)
  elif n[0] == 'top':
    print(arr[len(arr)-1] if len(arr) != 0 else -1)
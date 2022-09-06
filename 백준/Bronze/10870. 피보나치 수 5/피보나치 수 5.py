import sys
input=sys.stdin.readline

def fibonacci(i):
  if i >= 2:
    return fibonacci(i-1) + fibonacci(i-2)
  elif i == 0:
    return 0
  elif i == 1:
    return 1

print(fibonacci(int(input())))
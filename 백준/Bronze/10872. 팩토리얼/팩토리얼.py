import sys

input=sys.stdin.readline

n = int(input())

def recursion (a):
  if a > 1:
    return a * recursion (a-1)
  else :
    return 1

print(recursion(n))
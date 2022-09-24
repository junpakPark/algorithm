import sys
input = sys.stdin.readline

while True:
  arr = list(map(int, input().split()))
  arr.sort()
  a, b, c = arr
  if a == b == c == 0:
    break
  print("right") if c*c == b*b + a*a else print("wrong")  
import sys
input = sys.stdin.readline

T = int(input())
result = 0

for i in range(1, T+1):
  num = sum(map(int, str(i)))
  result = i + num
  if result == T:
    print(i)
    break
  if i == T:
    print(0)
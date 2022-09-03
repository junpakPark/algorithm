n = int(input())

for _ in range(n):
  a, b = map(str, input().split())
  sum = ''
  for i in range(len(b)):
    sum += b[i] * int(a)
  print(sum)
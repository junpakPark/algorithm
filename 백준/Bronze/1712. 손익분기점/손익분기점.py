import math

a, b, c = map(int, input().split())

if c == b :
  print(-1)
else:
  if a/(c-b) > 0 :
    print(math.trunc(a/(c-b)+1))
  else:
    print(-1)
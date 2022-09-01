a, b = map(int, input().split())

if b >= 45:
  print(a, b-45, sep=' ')
else :
  if a == 0:
    print(23, b+15, sep=' ')
  else :
    print(a-1, b+15, sep=' ')
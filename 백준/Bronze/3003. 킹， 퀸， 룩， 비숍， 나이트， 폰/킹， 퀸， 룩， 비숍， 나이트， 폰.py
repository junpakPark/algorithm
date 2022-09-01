a = list(map(int, input().split()))

b = [1, 1, 2, 2, 2, 8]

c= []

for i in range(len(a)):
  if a[i] == b[i]:
    c.append(0)
  else :
    c.append(-a[i]+b[i])

for i in range(len(c)):
  print(c[i], end=' ')
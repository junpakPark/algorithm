a = 10000
b = int(a ** 0.5)
c = [False,False] + [True]*(a-1)

for i in range(2, b + 1):
  if c[i]:
    for j in range(2*i, a + 1, i):
        c[j] = False
      
T = int(input())

for _ in range(T):
  n = int(input())
  x = n // 2
  y = n // 2
  while 1:
    if c[x] and c[y]:
      print(x, y)
      break
    x-=1
    y+=1
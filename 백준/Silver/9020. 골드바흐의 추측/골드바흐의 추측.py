a = 10000
b = int(a ** 0.5)
c = [False,False] + [True]*(a-1)

for i in range(2, b + 1):
  if c[i]:
    for j in range(2*i, a + 1, i):
        c[j] = False
      
primes=[i for i in range(2, a+1) if c[i] == True]

T = int(input())

for _ in range(T):
  n = int(input())
  array = []
  for k in primes:
    if n - k in primes:
      if 2 * k <= n :
        array.append((k ,n-k))
  print(*array[-1])
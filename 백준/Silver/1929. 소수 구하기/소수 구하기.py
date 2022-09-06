a, b = map(int, input().split())

def isPrime(a):
  m = int(a ** 0.5)
  if(a<2):
    return False
  for i in range(2, m+1):
    if(a%i==0):
      return False
  return True

for i in range(a, b + 1):
  if isPrime(i) == True:
    print(i)
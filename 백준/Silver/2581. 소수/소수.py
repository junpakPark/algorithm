a = int(input())
b = int(input())

def isPrime(a):
  if(a<2):
    return False
  for i in range(2,a):
    if(a%i==0):
      return False
  return True

array = []

for i in range(a, b + 1):
  if isPrime(i) == True:
    array.append(i)

if len(array) == 0:
  print(-1)
else :
  print(sum(array), min(array), sep='\n')
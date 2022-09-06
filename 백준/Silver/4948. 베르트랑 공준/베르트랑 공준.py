def isPrime(a):
  m = int(a ** 0.5)
  if(a<2):
    return False
  for i in range(2, m+1):
    if(a%i==0):
      return False
  return True

while True:
     n = int(input())
     if n != 0 :
       array = []
       for i in range(n + 1, 2 * n + 1):
         if isPrime(i) == True:
           array.append(i)
       print(len(array))
     else :
       break

T = int(input())
array = list(map(int, input().split()))

def isPrime(a):
  if(a<2):
    return False
  for i in range(2,a):
    if(a%i==0):
      return False
  return True

sum = 0

for i in array:
  if isPrime(i) == True:
    sum += 1

print(sum)
import sys
input=sys.stdin.readline

a = 123456*2
b = int(a ** 0.5)
c = [False,False] + [True]*(a-1)

for i in range(2, b + 1):
  if c[i]:
    for j in range(2*i, a + 1, i):
        c[j] = False

while True:
     n = int(input())
     if n != 0 :
       array = []
       for i in range(n + 1, 2 * n + 1):
         if c[i] == True:
           array.append(i)
       print(len(array))
     else :
       break
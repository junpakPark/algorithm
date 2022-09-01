a, b = map(int, input().split())
c = int(input())

h = (b+c)//60
m = (b+c)%60

if a + h >= 24:
    print(a+h-24, m)
else :
  print(a+h, m)

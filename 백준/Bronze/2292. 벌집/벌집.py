n = int(input())
a = 1
layer = 1

while n > a :
  a += 6 * layer
  layer += 1

print(layer)
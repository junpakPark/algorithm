x = int(input())

for _ in range(x):
  floor = int(input())
  num = int(input())
  array = [n for n in range(1, num+1)]
  for _ in range(floor):
    for i in range(num-1):
      array[i+1] += array[i]
  print(array[-1])
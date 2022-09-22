s= int(input())
i = 0

while True:
  i += 1
  s -= i
  if s <= i:
    print(i)
    break
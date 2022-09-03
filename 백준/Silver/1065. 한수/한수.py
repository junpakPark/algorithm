number = int(input())
array = []

for i in range(1, number + 1):
  if i >= 100:
    a = i // 100
    b = (i // 10) - 10 * a
    c = i % 10
    if a - b == b - c:
      array.append(i)
  else:
    array.append(i)

print(len(array))   
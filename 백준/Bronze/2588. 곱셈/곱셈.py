a = int(input())
b = str(input())
number = []

for i in b:
  number.append(int(i))

number.reverse()

for i in range(len(number)):
  print(a* number[i])

print(a*int(b))
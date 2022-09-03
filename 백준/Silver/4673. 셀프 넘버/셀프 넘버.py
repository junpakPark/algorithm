numbers = list(range(1,10001))
remove = []

for number in numbers:
  for n in str(number):
    number += int(n)
  if number <= 10000:
    remove.append(number)

result = [i for i in numbers if i not in remove]
for i in result:
  print(i)
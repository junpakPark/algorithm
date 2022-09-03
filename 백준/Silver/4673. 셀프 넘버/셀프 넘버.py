numbers = set(range(1,10001))
remove = set()

for number in numbers:
  for n in str(number):
    number += int(n)
  if number <= 10000:
    remove.add(number)

result = sorted(numbers - remove)
for i in result:
  print(i)
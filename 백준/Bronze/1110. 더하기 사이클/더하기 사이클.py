n = int(input())

number = n
count = 0

while True :
  tens = number // 10
  units = number % 10
  new_units = (tens + units) % 10
  number = units*10 + new_units
  count += 1
  if number == n:
    break

print(count)
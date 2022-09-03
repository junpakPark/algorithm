n = input()

number = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

sum = 0

for i in n:
  for j in number:
    if i in j:
      sum += number.index(j)+3

print(sum)
n = input()
croatia_alphabet = ['c=','c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in range(len(croatia_alphabet)):
  if croatia_alphabet[i] in n:
    n = n.replace(croatia_alphabet[i], '*')

print(len(n))
word = list(map(ord, input()))

array = [0] * 26

for i in range(len(word)):
  if word[i] >= 97 :
    array[word[i] - 97] += 1
  else :
    array[word[i] - 65 ] += 1

if array.count(max(array)) != 1:
  print('?')
else:
  print(chr(array.index(max(array)) + 65))
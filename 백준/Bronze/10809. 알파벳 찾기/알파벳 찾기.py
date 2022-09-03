s = list(map(ord, input()))
array = [-1] * 26

for i in range(len(s)):
  n = s[i] - ord('a')
  if array[n] == - 1:
    array[n] = i

print(*array)
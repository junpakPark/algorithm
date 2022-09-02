n = int(input())
for _ in range(n):
  result = input()
  count = 0
  score = 0
  for i in range(len(result)):
    if result[i] == 'O':
      count += 1
      score += count
    else :
      count = 0
      score += count
  print(score)
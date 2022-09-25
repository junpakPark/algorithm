arr = [int(input()) for _ in range(9)]

for i in range(len(arr)):
  if len(arr) != 9:
    break
  for j in range(len(arr)):
    if i == j:
      pass    
    elif sum(arr) - (arr[i] + arr[j]) == 100:
      arr.pop(i)
      arr.pop(j-1)
      break



arr.sort()
print(*arr, sep='\n')
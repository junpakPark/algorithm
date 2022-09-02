n = int(input())

for _ in range(n):
  array = list(map(int, input().split()))
  array.pop(0)
  avg = sum(array)/len(array)
  count = 0
  for i in range(len(array)):
    if array[i] > avg:
      count += 1
  print(format(count/len(array)*100, '.3f')+"%")
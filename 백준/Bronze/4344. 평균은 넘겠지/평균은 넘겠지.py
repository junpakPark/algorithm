n = int(input())

for _ in range(n):
  array = list(map(int, input().split()))
  student = array.pop(0)
  avg = sum(array)/student
  count = 0
  for i in range(student):
    if array[i] > avg:
      count += 1
  print(format(count/len(array)*100, '.3f')+"%")
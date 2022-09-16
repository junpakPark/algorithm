import sys
input = sys.stdin.readline

arr =[]
for _ in range(int(input())):
  arr.append(tuple(map(int, input().split())))

for i in range(len(arr)):
  count = 1
  for j in range(len(arr)):
    if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
      count +=1
  print(count, end=' ')
a, b = map(int, input().split())

array = list(map(int, input().split()))

result = []

for i in range(a):
  for j in range(i+1, a):
    for k in range(j+1, a):
      if array[i] + array[j] + array[k] <= b:
        result.append(array[i] + array[j] + array[k])

print(max(result))
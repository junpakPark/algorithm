n = int(input())
count = n

for _ in range(n):
  a = input()
  for i in range(len(a)-1):
    if a[i] == a[i+1]:
      pass
    elif a[i] in a[i+1:]:
      count -= 1
      break

print(count)
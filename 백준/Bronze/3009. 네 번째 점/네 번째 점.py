from collections import Counter

x = []
y = []
for _ in range(3):
  a, b = map(int, input().split())
  x.append(a)
  y.append(b)

print(Counter(x).most_common()[1][0], Counter(y).most_common()[1][0])
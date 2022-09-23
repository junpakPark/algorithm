import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = [input().strip() for _ in range(n)]

answer= []

for i in range(n - 8 + 1):
  for j in range(m - 8 + 1):
      W = 0
      B = 0
      for a in range(i, i + 8):
          for b in range(j, j + 8):
            if (a + b) % 2 == 0:
              if arr[a][b] != 'W':
                W += 1
              elif arr[a][b] != 'B':
                B += 1
            else:
              if arr[a][b] != 'B':
                W += 1
              elif arr[a][b] != 'W':
                B += 1
      answer.append(min(W, B))

print(min(answer))
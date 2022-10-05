import sys
input = sys.stdin.readline

n, k = map(int, input().split())
student = [[0] * 7 for _ in range(2)]


for _ in range(n):
  s, y = map(int, input().split())
  student[s][y] += 1

room = 0

for i in range(2):    
  for j in range(1, 7):
    room += student[i][j] // k
    if student[i][j] % k != 0:
      room += 1

print(room)
import sys
input = sys.stdin.readline

n = int(input())
stair = [int(input()) for _ in range(n)]

if n == 1:
  print(stair[0])
else:
  d = [[0, 0] for _ in range(n)]
  
  d[0][0] = stair[0]
  d[0][1] = 0
  d[1][0] = stair[1]
  d[1][1] = stair[0] + stair[1] 
  
  for i in range(2, n):
    d[i][0] = max(d[i-2][0], d[i-2][1]) + stair[i]
    d[i][1] = d[i-1][0] + stair[i]
  print(max(d[n-1][0], d[n-1][1]))
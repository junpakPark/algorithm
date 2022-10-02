import sys
input = sys.stdin.readline

n = int(input())
stair = [int(input()) for _ in range(n)]
dp = [0 for i in range(n)]

if n <=2:
    print(sum(stair))
else:
  dp[0] = stair[0]
  dp[1] = stair[1]
  dp[2] = stair[2]
  
  for i in range(3, n):
    dp[i] = min(dp[i - 2], dp[i - 3]) + stair[i]
  
  print(sum(stair) - min(dp[i-1], dp[i-2]))
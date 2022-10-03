import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
  count = 1
  queue = deque()
  queue.append((x, y))
  visited[x][y] = 1
  
  while queue:
    a, b = queue.popleft()
    
    for i in range(4):
      nx = a + dx[i]
      ny = b + dy[i]
      
      if -1 < nx < n and -1 < ny < m:
        if graph[nx][ny] == 1 and visited[nx][ny] == 0:
          visited[nx][ny] = 1
          queue.append((nx, ny))
          count += 1
  return count


n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

paint = []
for i in range(n):
  for j in range(m):
    if graph[i][j] == 1 and visited[i][j] == 0:
      paint.append(bfs(i, j))
  
if len(paint) == 0:
    print(len(paint))
    print(0)
else:
    print(len(paint))
    print(max(paint))
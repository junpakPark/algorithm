import sys
input = sys.stdin.readline

n = int(input())
v = int(input())

graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(v):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

def dfs(v):
  visited[v] = 1
  for next_com in graph[v]:
    if visited[next_com] == 0:
      dfs(next_com)

dfs(1)
print(visited.count(1)-1)
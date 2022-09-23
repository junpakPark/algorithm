import sys
input = sys.stdin.readline

n = int(input())
arr1 = list(map(int, input().split()))

m = int(input())
arr2 = list(map(int, input().split()))

intersection = set(arr1) & set(arr2)
answer = [0] * m

for i in range(m):
  if arr2[i] in intersection:
    answer[i] += 1

print(*answer, sep='\n')
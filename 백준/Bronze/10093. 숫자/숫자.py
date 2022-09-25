import sys
input = sys.stdin.readline

a = sorted(list(map(int, input().split())))
arr = [i for i in range(a[0]+1, a[1])]
if a[0] == a[1]:
  print(0)
else:
  print(a[1] - (a[0]+1))
print(*arr)
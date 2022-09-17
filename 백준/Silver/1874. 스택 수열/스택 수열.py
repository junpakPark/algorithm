import sys
input = sys.stdin.readline

stack = [input().strip() for _ in range(int(input()))]

arr = []
ans = []
is_sequence = True

count = 1
for i in stack:
  while count <= int(i):
    arr.append(count)
    ans.append('+')
    count += 1

  if arr[-1] == int(i):
    arr.pop()
    ans.append('-')

  else:
    is_sequence = False
    break

if is_sequence == False:
    print("NO")
else:
  print(*ans, sep='\n')
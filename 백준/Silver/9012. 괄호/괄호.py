import sys
input = sys.stdin.readline

for _ in range(int(input())):
  str = input().strip()
  stack = []
  isVPS = True
  for i in str:
    if i == '(':
      stack.append('i')
    elif i == ')':
      if stack:
        stack.pop()
      else :
        isVPS = False
        break
  if not stack and isVPS:
    print('YES')
  else:
    print('NO')
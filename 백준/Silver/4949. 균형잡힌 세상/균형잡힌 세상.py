import sys
input = sys.stdin.readline

while True:
  s = input().rstrip()
  stack = []
  is_pop = True
  if s == '.':
    break
  for i in s:
    if i == '(' or i == '[':
      stack.append(i)
    elif i == ')':
      if not stack or stack[-1] != '(':
        is_pop = False
        break
      elif stack[-1] == '(':
        stack.pop()
    elif i == ']':
      if not stack or stack[-1] != '[':
        is_pop = False
        break
      elif stack[-1] == '[':
        stack.pop()    
  if is_pop and not stack:
    print("yes") 
  else:
    print("no")
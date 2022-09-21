import sys
input = sys.stdin.readline().strip

iron_stick = input()
stack = []
count = 0

for i in range(len(iron_stick)):
  if iron_stick[i] == '(':
    stack.append('(')
  else:
    if iron_stick[i-1] == '(' :
      stack.pop()
      count += len(stack)
    else:
      stack.pop()
      count += 1

print(count)
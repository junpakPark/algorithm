import sys
input = sys.stdin.readline

s = list(input().strip())
s2= []

for _ in range(int(input())):
  command = input().split()
  if command[0] == 'L' and s:
    s2.append(s.pop())
  elif command[0] == 'D' and s2:
    s.append(s2.pop())
  elif command[0] == 'B' and s:
    s.pop()
  elif command[0] == 'P' :
    s.append(command[1])

s += s2[::-1]

print(*s, sep='')
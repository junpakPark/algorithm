import sys
input=sys.stdin.readline

array = []

for _ in range(int(input())):
  array.append(int(input()))

array.sort()

print(*array, sep='\n')
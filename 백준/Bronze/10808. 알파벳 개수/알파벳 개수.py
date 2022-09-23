import sys
input = sys.stdin.readline

arr = [0] * 26

for i in input().strip():
  arr[ord(i)-ord("a")] += 1
print(*arr)
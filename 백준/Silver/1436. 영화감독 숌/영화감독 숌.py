import sys
input = sys.stdin.readline

n = int(input())

arr = []

for i in range(2700000):
  if i == 666 or '666' in str(i):
    arr.append(str(i))

print(arr[n-1])
import sys
input = sys.stdin.readline

n = int(input())
arr1 = list(map(int, input().split()))

m = int(input())
arr2 = list(map(int, input().split()))

intersection = set(arr1) & set(arr2)

for i in arr2:
  if i in intersection:
    print(1, end=' ')
  else :
    print(0, end=' ')
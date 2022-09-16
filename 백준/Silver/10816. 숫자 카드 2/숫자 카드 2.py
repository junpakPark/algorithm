import sys
from collections import Counter 
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

cntr = Counter(a)

for i in b:
  print(cntr[i], end=' ')
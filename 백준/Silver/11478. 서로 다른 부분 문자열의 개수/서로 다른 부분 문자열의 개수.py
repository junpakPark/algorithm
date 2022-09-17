import sys
int = sys.stdin.readline

S = input()

arr = []

for i in range(len(S)+1):
  for j in range(i+1, len(S)+1):
    arr.append(S[i:j])

print(len(set(arr)))
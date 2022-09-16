import sys
input = sys.stdin.readline

a, b = map(int, input().split())

s = [str(input().rstrip()) for _ in range(a)]
t = [str(input().rstrip()) for _ in range(b)]

ans = 0
for i in t:
  if i in s:
    ans += 1

print(ans)
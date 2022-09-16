import sys
input = sys.stdin.readline

a, b = map(int, input().split())

pokemon = [input().rstrip() for _ in range(a)]
test = [input().rstrip() for _ in range(b)]

for i in test:
  if i.isdigit():
    print(pokemon[int(i)-1])
  else:
    print(pokemon.index(i)+1)
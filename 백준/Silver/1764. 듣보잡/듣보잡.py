import sys
input = sys.stdin.readline

n, m = map(int, input().split())

can_not_hear_man = [input().rstrip() for _ in range(n)]
can_not_see_man = [input().rstrip() for _ in range(m)]

intersection = list(set(can_not_hear_man) & set (can_not_see_man))

intersection.sort()

print(len(intersection), *intersection, sep='\n')
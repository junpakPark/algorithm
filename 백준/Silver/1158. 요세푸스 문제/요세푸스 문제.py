import sys
input = sys.stdin.readline

a, b = map(int, input().split())

people = [i + 1 for i in range(a)]
ans = []
num = b - 1

for i in range(a):
    if len(people) > num:
        ans.append(people.pop(num))
        num += b - 1
    elif len(people) <= num:
        num = num % len(people)
        ans.append(people.pop(num))
        num += b -1
        
print("<", ', '.join(str(i) for i in ans), ">", sep = '')
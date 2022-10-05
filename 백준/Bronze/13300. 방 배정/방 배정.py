import sys
from collections import Counter
input = sys.stdin.readline

n, k = map(int, input().split())

male = []
female = []

for _ in range(n):
  s, y = map(int, input().split())
  if s == 0 :
    female.append(y)
  else:
    male.append(y)

male_dict = Counter(male)
female_dict = Counter(female)

room = 0

for i in male_dict.keys():
  if male_dict[i] % k == 0:
    room += male_dict[i] // k
  else:
    room += male_dict[i] // k + 1
    
for i in female_dict.keys():
  if female_dict[i] % k == 0:
    room += female_dict[i] // k
  else:
    room += female_dict[i] // k + 1

print(room)
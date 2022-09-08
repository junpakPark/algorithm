import sys
input=sys.stdin.readline

array = [0] * 10001

for _ in range(int(input())):
  array[int(input())] += 1

for i in range(len(array)):
    if array[i] != 0:
        for _ in range(array[i]):
            print(i)
import sys
input = sys.stdin.readline().rstrip

array = [i for i in str(input())]
array.sort(reverse=True)
print(*array, sep='')
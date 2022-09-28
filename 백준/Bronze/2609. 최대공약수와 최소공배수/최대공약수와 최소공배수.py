import math
import sys
input = sys.stdin.readline
a, b = map(int, input().split())
print(math.gcd(a, b) , a * b // math.gcd(a, b), sep='\n')
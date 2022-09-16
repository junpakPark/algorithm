import sys
input = sys.stdin.readline

n, m = map(int, input().split())

A = set(map(int, input().split()))
B = set(map(int, input().split()))

union = A | B
intersection = A & B

print(len(union-intersection))
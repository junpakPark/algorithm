n = int(input())
array = list(map(int, input().split()))
print(sum(array) / max(array) * 100 / n)
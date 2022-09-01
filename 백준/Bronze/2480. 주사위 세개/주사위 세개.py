a, b, c = map(int, input().split())

result = list(set([a, b, c]))
result.sort(reverse=True)

if len(result) == 3 :
  print(result[0]*100)
elif len(result) == 2 :
  if a == b:
    print(a*100 + 1000)
  elif b == c:
    print(b*100 + 1000)
  else :
    print(c*100 + 1000)
else :
  print(result[0]*1000+10000)
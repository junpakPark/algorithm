import sys
input = sys.stdin.readline
ans = ''
stack = ''
tag = False

for i in input().strip():
    if tag == False:
        if i == "<":
            tag = True
            ans += stack[::-1]
            stack = "<"

        elif i == " ":
            ans += stack[::-1] + " "
            stack = ''
        else:
            stack += i
    elif tag == True:
        stack += i
        if i == ">":
            tag = False
            ans += stack
            stack = ''
print(ans+stack[::-1])
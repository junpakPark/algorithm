def solution(s):
    p = y = 0
    for i in s.lower():
        if i == 'p':
            p += 1
        elif i == 'y':
            y += 1

    return p == y
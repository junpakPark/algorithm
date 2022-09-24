def solution(n):
    return int(''.join(sorted(list(str(n)))[::-1]))
def solution(n):
    arr = []
    for i in range(len(str(n))):
        arr.append(int(str(n)[i]))
    answer = sum(arr)

    return answer
import sys
from collections import deque 
input = sys.stdin.readline

for _ in range(int(input())):
    a, b = map(int,input().split())
    queue = deque(list(map(int,input().split())))
    arr = deque([i for i in range(a)])
    cnt = 0 
    while queue:
        if queue[0] == max(queue):
            cnt += 1
            queue.popleft()
            if arr.popleft() == b:
                print(cnt)
        else:
            queue.append(queue.popleft())
            arr.append(arr.popleft())
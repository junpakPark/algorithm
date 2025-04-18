import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        final PriorityQueue<Integer> maxHeaps = new PriorityQueue<>(Collections.reverseOrder());
        final Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            final int priority = priorities[i];
            maxHeaps.offer(priority);
            queue.offer(new int[]{i, priority});
        }
        
        int answer = 0;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            
            if (current[1] < maxHeaps.peek()) {
                queue.offer(current);
                continue;
            }
            maxHeaps.poll();
            answer++;
            if (current[0] == location) {
                return answer;
            }
        }
        
        
        return answer;
    }
}
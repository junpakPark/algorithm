import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            final int e = enemy[i];
            pq.offer(e);
            n -= e;
            
            if (n >= 0) {
                continue;
            }
            if (k <= 0) {
                return i;
            }
            n += pq.poll();
            k--;
        }
        
        return enemy.length;
    }
}
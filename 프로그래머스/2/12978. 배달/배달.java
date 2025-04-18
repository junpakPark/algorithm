import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        final List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            final int from = r[0];
            final int to = r[1];
            final int cost = r[2];
            
            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }
        
        final int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            final int[] current = pq.poll();
            final int node = current[0];
            final int cost = current[1];
            
            if (cost > distances[node]) {
                continue;
            }
            
            for (int[] next: graph.get(node)) {
                final int nextNode = next[0];
                final int nextCost = next[1];
                final int totalCost = cost + nextCost;
                
                if (distances[nextNode] > totalCost) {
                    distances[nextNode] = totalCost;
                    pq.offer(new int[]{nextNode, totalCost});
                }
            }
        }
        
        int answer = 0;
        for (int distance : distances) {
           if (distance <= K) {
               answer++;
           } 
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    
    private static final int INF = 1_000_000_000;
    
    public int solution(int N, int[][] road, int K) {
        final int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        for (int[] r : road) {
            graph[r[0]][r[1]] = Math.min(graph[r[0]][r[1]], r[2]);
            graph[r[1]][r[0]] = Math.min(graph[r[1]][r[0]], r[2]);
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];
            
            if (cost > dist[node]) {
                continue;
            }
            
           for (int i = 1; i <= N; i++) {
                if (graph[node][i] == INF) {
                    continue;
                }
                int totalCost = cost + graph[node][i];
                if (dist[i] > totalCost) {
                    dist[i] = totalCost;
                    pq.offer(new int[]{i, totalCost});
                }
            }
        }
        
        int answer = 0;
        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }
        return answer;
    }
}
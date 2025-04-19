import java.util.*;

class Solution {
    
    private static final int INF = 1_000_000_000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }
        
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            if (dist[s][k] == INF || dist[k][a] == INF || dist[k][b] == INF) {
                continue;
            }
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return answer;
    }
}
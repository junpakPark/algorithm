import java.util.*;

class Solution {
    
    private static final int INF = 1_000_000_000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = Math.min(graph[fare[0]][fare[1]], fare[2]);
            graph[fare[1]][fare[0]] = Math.min(graph[fare[1]][fare[0]], fare[2]);
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = INF;
        for (int k = 1; k <= n; k++) {
            if (graph[s][k] == INF || graph[k][a] == INF || graph[k][b] == INF) {
                continue;
            }
            answer = Math.min(answer, graph[s][k] + graph[k][a] + graph[k][b]);
        }
        return answer;
    }
}
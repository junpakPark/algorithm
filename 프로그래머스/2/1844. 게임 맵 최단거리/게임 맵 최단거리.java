import java.util.*;

class Solution {
    
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] maps) {
        final int n = maps.length;
        final int m = maps[0].length;
        final boolean[][] visited = new boolean[n][m];
        
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, maps[0][0]});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            final int[] current = queue.poll();
            final int x = current[0];
            final int y = current[1];
            final int steps = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return steps;
            }
            
            for (int[] direction : directions) {
                final int nx = x + direction[0];
                final int ny = y + direction[1];
                
                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    continue;
                }
                if(visited[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }
                queue.offer(new int[]{nx, ny, steps + 1});
                visited[nx][ny] = true;
            }
            
        }
        return -1;
    }
}
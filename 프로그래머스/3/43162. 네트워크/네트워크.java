class Solution {
    
    private int[][] map;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.map = computers;
        this. visited = new boolean[n];
        
        int answer = 0;
        for (int i = 0; i < n; i++){
            if (visited[i]) {
                continue;
            }
            answer++;
            dfs(i);
        }
        return answer;
    }
    
    private void dfs(int depth) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && map[depth][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
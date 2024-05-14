class Solution {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private int[][] grid;
    private int m;
    private int n;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        return answer;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int v = grid[i][j];
        grid[i][j] = 0;
        
        int answer = 0;
        for (int k = 0; k < 4; ++k) {
            answer = Math.max(answer, v + dfs(i + dirs[k], j + dirs[k + 1]));
        }
        grid[i][j] = v;
        
        return answer;
    }
}

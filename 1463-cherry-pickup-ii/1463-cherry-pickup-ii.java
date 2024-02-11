class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Integer[][][] dp = new Integer[rows][cols][cols];
        
        return dfs(grid, dp, 0, 0, cols - 1);
    }

    private int dfs(int[][] grid, Integer[][][] dp, int row, int col1, int col2) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }
        
        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }
        if (row < grid.length - 1) {
            int max = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, dfs(grid, dp, row + 1, newCol1, newCol2));
                }
            }
            result += max;
        }
        dp[row][col1][col2] = result;
        return result;
    }
}
class Solution {

    private char[][] grid;
    private int count = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        bfs(i, j + 1);
        bfs(i, j - 1);
        bfs(i + 1, j);
        bfs(i - 1, j);
    }

}

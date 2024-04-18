class Solution {
    private int[][] grid;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += getPerimeter(i, j);
                }
            }
        }
        return perimeter;
    }

    private int getPerimeter(final int i, final int j) {
        int result = 4;
        if (i > 0 && grid[i - 1][j] == 1) {
            result -= 2;
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            result -= 2;
        }
        return result;
    }
}
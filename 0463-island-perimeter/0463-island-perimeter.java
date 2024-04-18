class Solution {

    private int[][] grid;
    private int rows;
    private int columns;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    perimeter += getPerimeter(i, j);
                }
            }
        }

        return perimeter;
    }

    private int getPerimeter(final int i, final int j) {
        int perimeter = 0;
        if (i == 0 || grid[i - 1][j] == 0) {
            perimeter++;
        }
        if (i == rows - 1 || grid[i + 1][j] == 0) {
            perimeter++;
        }
        if (j == 0 || grid[i][j - 1] == 0) {
            perimeter++;
        }
        if (j == columns - 1 || grid[i][j + 1] == 0) {
            perimeter++;
        }
        return perimeter;
    }
}

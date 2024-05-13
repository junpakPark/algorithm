class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] ^= 1;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < n; ++j) {
            int count = 0;
            for (int[] ints : grid) {
                count += ints[j];
            }
            result += Math.max(count, m - count) * (1 << (n - j - 1));
        }
        return result;
    }
}
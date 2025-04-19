class Solution {
  private final int MOD = 20170805;
  public int solution(int m, int n, int[][] cityMap) {
        final int[][] right = new int[m + 1][n + 1];
        final int[][] down = new int[m + 1][n + 1];

        right[1][1] = 1;
        down[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 0) {
                    right[i][j] += (right[i][j - 1] + down[i - 1][j]) % MOD;
                    down[i][j] += (down[i - 1][j] + right[i][j - 1]) % MOD;
                } else if (cityMap[i - 1][j - 1] == 2) {
                    right[i][j] = right[i][j - 1];
                    down[i][j] = down[i - 1][j];
                }
            }
        }

        return (right[m][n - 1] + down[m - 1][n]) % MOD;
    }
}
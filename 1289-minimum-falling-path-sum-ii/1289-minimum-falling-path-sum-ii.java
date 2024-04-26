class Solution {
	public int minFallingPathSum(int[][] grid) {
		int n = grid.length;
		int[][] dp = new int[n][n];

		System.arraycopy(grid[0], 0, dp[0], 0, n);

		for (int i = 1; i < n; i++) {
			int firstMin = Integer.MAX_VALUE;
			int secondMin = Integer.MAX_VALUE;
			int firstMinIndex = -1;

			for (int j = 0; j < n; j++) {
				if (dp[i - 1][j] < firstMin) {
					secondMin = firstMin;
					firstMin = dp[i - 1][j];
					firstMinIndex = j;
					continue;
				}
				if (dp[i - 1][j] < secondMin) {
					secondMin = dp[i - 1][j];
				}
			}

			// 현재 행 업데이트
			for (int j = 0; j < n; j++) {
				if (j == firstMinIndex) {
					dp[i][j] = grid[i][j] + secondMin;
					continue;
				}
				dp[i][j] = grid[i][j] + firstMin;
			}
		}
		
		int minPathSum = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			minPathSum = Math.min(minPathSum, dp[n - 1][j]);
		}

		return minPathSum;
	}
}


class Solution {
	public int findRotateSteps(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		int[][] dp = new int[m][n];
		
		
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = ring.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, new ArrayList<>());
			}
			map.get(c).add(i);
		}
		
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		for (int i : map.get(key.charAt(0))) {
			dp[0][i] = Math.min(dp[0][i], Math.min(i, n - i) + 1);
		}
		
		for (int i = 1; i < m; i++) {
			for (int j : map.get(key.charAt(i))) {
				for (int k : map.get(key.charAt(i - 1))) {
					int diff = Math.abs(j - k);
					int step = Math.min(diff, n - diff) + 1;
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + step);
				}
			}
		}
		
		int minSteps = Integer.MAX_VALUE;
		for (int i : map.get(key.charAt(m - 1))) {
			minSteps = Math.min(minSteps, dp[m - 1][i]);
		}

		return minSteps;
	}
}

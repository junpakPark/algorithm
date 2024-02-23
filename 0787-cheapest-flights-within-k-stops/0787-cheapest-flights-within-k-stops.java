class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K + 2][n];
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        
        dp[0][src] = 0;

        
        for (int i = 1; i <= K + 1; i++) {
            dp[i][src] = 0; 
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }

        return dp[K + 1][dst] < Integer.MAX_VALUE / 2 ? dp[K + 1][dst] : -1;
    }

}
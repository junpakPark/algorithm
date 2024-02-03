public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; ++i) {
            int currMax = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; ++j) {
                currMax = Math.max(currMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + currMax * j);
            }
        }
        return dp[n - 1];
    }
}

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[128];
        int maxLen = 0;

        for (char c : s.toCharArray()) {
            int maxLengthForC = 0;
            for (char j = (char) Math.max('a', c - k); j <= Math.min('z', c + k); j++) {
                maxLengthForC = Math.max(maxLengthForC, dp[j]);
            }
            dp[c] = maxLengthForC + 1;
            maxLen = Math.max(maxLen, dp[c]);
        }

        return maxLen;
    }
}
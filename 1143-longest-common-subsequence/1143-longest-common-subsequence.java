class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int text1Length = char1.length;
        int text2Length = char2.length;

        int[][] dp = new int[text1Length + 1][text2Length + 1];

        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {

                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1Length][text2Length];
    }
}
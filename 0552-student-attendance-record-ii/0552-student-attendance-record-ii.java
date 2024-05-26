class Solution {
  private static final int MOD = 1_000_000_007;

  public int checkRecord(int n) {
    long[][] dp = new long[2][3];
    dp[0][0] = 1;

    while (n-- > 0) {
      long[][] prev = Arrays.stream(dp)
                            .map(long[]::clone)
                            .toArray(long[][]::new);

      
      dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % MOD;

      dp[0][1] = prev[0][0];
      dp[0][2] = prev[0][1];


      dp[1][0] = (prev[0][0] + prev[0][1] + prev[0][2] + prev[1][0] + prev[1][1] + prev[1][2]) % MOD;

      dp[1][1] = prev[1][0];
      dp[1][2] = prev[1][1];
    }

    long result = 0;
    for (int i = 0; i < 2; ++i) {
      for (int j = 0; j < 3; ++j) {
        result = (result + dp[i][j]) % MOD;
      }
    }

    return (int) result;
  }

}

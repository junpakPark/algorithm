class Solution {
  public long maximumImportance(int n, int[][] roads) {
    long answer = 0;
    long[] count = new long[n];

    for (int[] road : roads) {
      int u = road[0];
      int v = road[1];
      count[u]++;
      count[v]++;
    }

    Arrays.sort(count);

    for (int i = 0; i < n; ++i)
      answer += (i + 1) * count[i];

    return answer;
  }
}

class Solution {

    private int[][] land;
    private int m;
    private int n;
    int h = 0;
    int k = 0;

    public int[][] findFarmland(int[][] land) {
        this.land = land;
        this.m = land.length;
        this.n = land[0].length;

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    dfs(i, j);
                    ans.add(new int[]{i, j, h, k});
                    h = 0;
                    k = 0;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public void dfs(int u, int v) {
        if (u < 0 || v < 0 || u >= m || v >= n || land[u][v] == 0) {
            return;
        }
        land[u][v] = 0;
        h = Math.max(h, u);
        k = Math.max(k, v);

        dfs(u + 1, v);
        dfs(u, v + 1);
    }
}

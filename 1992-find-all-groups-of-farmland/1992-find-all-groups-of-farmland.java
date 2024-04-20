public class Solution {
    private int[][] land;
    private boolean[][] visited;
    private int m, n;

    public int[][] findFarmland(int[][] land) {
        this.land = land;
        m = land.length;
        n = land[0].length;
        visited = new boolean[m][n];

        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] bounds = new int[]{i, j, i, j};
                    dfs(i, j, bounds);
                    results.add(new int[]{bounds[0], bounds[1], bounds[2], bounds[3]});
                }
            }
        }

        return results.toArray(new int[results.size()][]);
    }

    private void dfs(int i, int j, int[] bounds) {
        if (i < 0 || i >= m || j < 0 || j >= n || land[i][j] != 1 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        bounds[0] = Math.min(bounds[0], i);
        bounds[1] = Math.min(bounds[1], j);
        bounds[2] = Math.max(bounds[2], i);
        bounds[3] = Math.max(bounds[3], j);

        dfs(i + 1, j, bounds);
        dfs(i - 1, j, bounds);
        dfs(i, j + 1, bounds);
        dfs(i, j - 1, bounds);
    }
}

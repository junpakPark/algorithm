class Solution {

    private static final char[] dir = {'d', 'l', 'r', 'u'};
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};

    private StringBuilder route;
    private String answer;

    private int endRow, endCol;
    private int arrRow, arrCol; //미로 길이

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = new StringBuilder();
        endRow = r;
        endCol = c;
        arrRow = n;
        arrCol = m;

        int length = distance(x, y, r, c);
        if ((k - length) % 2 == 1 || k < length) {
            return "impossible";
        }

        dfs(x, y, 0, k);

        if (answer == null) {
            return "impossible";
        }
        return answer;
    }

    private int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    private void dfs(int r, int c, int depth, int k) {
        if (answer != null) {
            return;
        }
        if (depth + distance(r, c, endRow, endCol) > k) {
            return;
        }
        if (k == depth) {
            answer = route.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = r + dx[i];
            int nextCol = c + dy[i];

            if (0 < nextRow && nextRow <= arrRow && 0 < nextCol && nextCol <= arrCol) {
                route.append(dir[i]);
                dfs(nextRow, nextCol, depth + 1, k);
                route.delete(depth, depth + 1);
            }

        }
    }
    
}

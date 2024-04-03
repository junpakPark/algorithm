
class Solution {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    private String word;
    private char[][] board;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }

        if (isRightWord(x, y, index)) {
            return false;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (dfs(nx, ny, index + 1)) {
                return true;
            }
        }
        visited[x][y] = false;

        return false;
    }

    private boolean isRightWord(int x, int y, int index) {
        return !(0 <= x && x < board.length && 0 <= y && y < board[0].length)
                || visited[x][y] || board[x][y] != word.charAt(index);
    }

}

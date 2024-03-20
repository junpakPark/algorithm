class Solution {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    private int row;
    private int column;
    private int[][] board;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        row = board.length;
        column = board[0].length;
        this.board = board;

        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    private int dfs(int ax, int ay, int bx, int by) {
        if (board[ax][ay] == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            int anx = ax + dx[i];
            int any = ay + dy[i];

            if (!canMove(anx, any)) {
                continue;
            }

            board[ax][ay] = 0;
            int moveCount = dfs(bx, by, anx, any) + 1;
            board[ax][ay] = 1;

            if (result % 2 == 0 && moveCount % 2 == 1) {
                result = moveCount;
                continue;
            }
            if (result % 2 == 0 && moveCount % 2 == 0) {
                result = Math.max(result, moveCount);
                continue;
            }
            if (result % 2 == 1 && moveCount % 2 == 1) {
                result = Math.min(result, moveCount);
            }
        }

        return result;
    }

    private boolean canMove(final int anx, final int any) {
        return 0 <= anx && anx < row && 0 <= any && any < column && board[anx][any] == 1;
    }
}

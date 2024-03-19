import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int solution(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(".")) {
                    continue;
                }
                board[i][j] = "X";
                if (isWin(board, i, j)) {
                    return 1;
                }
                board[i][j] = ".";
            }
        }
        return 0;
    }

    private static boolean isWin(String[][] board, int x, int y) {

        for (int i = -4; i <= 0; i++) {
            if (0 <= x + i && x + i + 4 < board.length) {
                if (checkLine(board, x + i, y, 1, 0)) {
                    return true;
                }
            }

            if (0 <= y + i && y + i + 4 < board[0].length) {
                if (checkLine(board, x, y + i, 0, 1)) {
                    return true;
                }
            }

        }

        for (int i = -4; i <= 0; i++) {
            if (0 <= x + i && x + i + 4 < board.length && 0 <= y + i && y + i + 4 < board[0].length) {
                if (checkLine(board, x + i, y + i, 1, 1)) {
                    return true;
                }
            }
            if (0 <= x + i && x + i + 4 < board.length && 0 <= y - i - 4 && y - i < board[0].length) {
                if (checkLine(board, x + i, y - i, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkLine(String[][] board, int x, int y, int dx, int dy) {
        for (int i = 0; i < 5; i++) {
            if (!board[x + i * dx][y + i * dy].equals("X")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            String row = bufferedReader.readLine();
            board[i] = row.split("");
        }

        System.out.println(solution(board));

        bufferedReader.close();
    }


}

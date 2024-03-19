import java.io.*;
import java.util.*;

public class Main {

    private final static StringBuilder STRING_BUILDER = new StringBuilder();


    private static void solution(int[][] board, int[][] nextNumbers) {
        int row = board.length;
        int column = board[0].length;

        Map<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                map.put(board[i][j], new Point(i, j));
            }
        }

        int count = 0;
        boolean[][] bingo = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (isEnd(bingo)) {
                    break;
                }
                count++;
                Point point = map.get(nextNumbers[i][j]);
                bingo[point.x][point.y] = true;
            }
        }
        STRING_BUILDER.append(count);
    }

    private static boolean isEnd(boolean[][] bingo) {
        int row = 0;

        int upCount = 0;
        int downCount = 0;

        for (int i = 0; i < 5; i++) {
            int rowCount = 0;
            int columnCount = 0;

            if (bingo[i][i]) {
                upCount++;
            }
            if (bingo[i][4 - i]) {
                downCount++;
            }

            for (int j = 0; j < 5; j++) {
                if (bingo[i][j]) {
                    rowCount++;
                }
                if (bingo[j][i]) {
                    columnCount++;
                }
            }

            if (rowCount == 5) {
                row++;
            }
            if (columnCount == 5) {
                row++;
            }
        }

        if (upCount == 5) {
            row++;
        }
        if (downCount == 5) {
            row++;
        }

        return row >= 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = createArr(bufferedReader);
        int[][] nextNumbers = createArr(bufferedReader);

        solution(board, nextNumbers);
        System.out.println(STRING_BUILDER);

        bufferedReader.close();
    }

    private static int[][] createArr(final BufferedReader bufferedReader) throws IOException {
        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String string = bufferedReader.readLine();
            String[] numbers = string.split(" ");

            int[] row = new int[5];
            for (int j = 0; j < 5; j++) {
                row[j] = Integer.parseInt(numbers[j]);
            }
            board[i] = row;
        }
        return board;
    }

    private static class Point {
        private final int x;
        private final int y;

        private Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

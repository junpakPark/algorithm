import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int n;
    private static int[][] garden;
    private static boolean[][] visited;
    private static int minCost = Integer.MAX_VALUE;


    private static void solution(int count, int cost) {
        if (count == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (canPlant(i, j)) {
                    int newCost = plant(i, j);
                    solution(count + 1, cost + newCost);
                    unplant(i, j);
                }
            }
        }

    }

    private static boolean canPlant(int x, int y) {
        if (visited[x][y]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private static int plant(int x, int y) {
        int cost = garden[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
            cost += garden[nx][ny];
        }
        return cost;
    }

    private static void unplant(int x, int y) {
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        garden = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            String[] split = bufferedReader.readLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                row[j] = Integer.parseInt(split[j]);
            }
            garden[i] = row;
        }
        visited = new boolean[n][n];

        solution(0, 0);

        System.out.println(minCost);

        bufferedReader.close();
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;


    private static int[][] solution(int[][] arr, int[] rotations) {
        for (int rotation : rotations) {
            arr = rotate(rotation, arr);
        }
        return arr;
    }

    private static int[][] rotate(int rotation, int[][] arr) {
        if (rotation == 1) {
            return rotateOne(arr);
        }
        if (rotation == 2) {
            return rotateTwo(arr);
        }
        if (rotation == 3) {
            return rotateThree(arr);
        }
        if (rotation == 4) {
            return rotateFour(arr);
        }
        if (rotation == 5) {
            return rotateFive(arr);
        }
        return rotateSix(arr);
    }


    private static int[][] rotateOne(int[][] arr) {
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N - i - 1][j];
                arr[N - i - 1][j] = temp;
            }
        }
        return arr;
    }


    private static int[][] rotateTwo(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = temp;
            }
        }
        return arr;
    }


    private static int[][] rotateThree(int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();

        int newRow = M;
        int newColumn = N;

        int[][] copy = new int[newRow][newColumn];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                queue.add(arr[i][j]);
            }
        }

        for (int j = N - 1; j >= 0; j--) {
            for (int i = 0; i < M; i++) {
                copy[i][j] = queue.poll();
            }
        }

        N = newRow;
        M = newColumn;

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) {
                System.arraycopy(copy[i], 0, arr[i], 0, M);
            }
        }
        return arr;
    }


    private static int[][] rotateFour(int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();

        // 가로/세로 길이 변환 시 사용
        int newRow = M;
        int newColumn = N;

        int[][] copy = new int[newRow][newColumn];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                queue.add(arr[i][j]);
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = M - 1; i >= 0; i--) {
                copy[i][j] = queue.poll();
            }
        }

        N = newRow;
        M = newColumn;

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) {
                System.arraycopy(copy[i], 0, arr[i], 0, M);
            }
        }
        return arr;
    }

    private static int[][] rotateFive(int[][] arr) {
        int[][] copy = new int[N][M];
        int n = N / 2;
        int m = M / 2;

        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i], m, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], m, copy[i + n], m, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i + n], m, copy[i + n], 0, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i + n], 0, copy[i], 0, m);
        }

        for (int i = 0; i < N; i++) {
            if (M >= 0) {
                System.arraycopy(copy[i], 0, arr[i], 0, M);
            }
        }
        return copy;
    }


    private static int[][] rotateSix(int[][] arr) {
        int[][] copy = new int[N][M];
        int n = N / 2;
        int m = M / 2;

        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i + n], 0, copy[i + n], m, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i + n], m, copy[i], m, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, copy[i + n], 0, m);
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], m, copy[i], 0, m);
        }

        for (int i = 0; i < N; i++) {
            if (M >= 0) {
                System.arraycopy(copy[i], 0, arr[i], 0, M);
            }
        }

        return copy;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        int r = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] row = new int[M];
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                row[j] = Integer.parseInt(tokenizer.nextToken());
            }
            arr[i] = row;
        }

        int[] rotation = new int[r];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < r; i++) {
            rotation[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[][] answer = solution(arr, rotation);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.print(System.lineSeparator());
        }

        bufferedReader.close();
    }

}

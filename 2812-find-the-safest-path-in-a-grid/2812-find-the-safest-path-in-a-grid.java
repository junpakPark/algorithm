class Solution {
    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] gridArr = new int[n][n];
        int[][] safety = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        initializeGrids(grid, gridArr, safety, queue);

        if (gridArr[0][0] == 1 || gridArr[n - 1][n - 1] == 1) {
            return 0;
        }

        calculateSafetyDistances(safety, queue, n);

        return findMaxSafenessPath(safety, gridArr, n);
    }

    private void initializeGrids(List<List<Integer>> grid, int[][] gridArr, int[][] safety, Queue<int[]> queue) {
        int n = grid.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    gridArr[i][j] = 1;
                    safety[i][j] = 0;
                    queue.add(new int[]{i, j, 0});
                } else {
                    safety[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    private void calculateSafetyDistances(int[][] safety, Queue<int[]> queue, int n) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            int currSafety = curr[2];

            for (int[] dir : DIRECTIONS) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (isValid(nextX, nextY, n) && safety[nextX][nextY] > currSafety + 1) {
                    queue.add(new int[]{nextX, nextY, currSafety + 1});
                    safety[nextX][nextY] = currSafety + 1;
                }
            }
        }
    }

    private int findMaxSafenessPath(int[][] safety, int[][] gridArr, int n) {
        PriorityQueue<int[]> pathQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        pathQueue.add(new int[]{0, 0, safety[0][0]});
        gridArr[0][0] = 2;

        while (!pathQueue.isEmpty()) {
            int[] curr = pathQueue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            if (currX == n - 1 && currY == n - 1) {
                return currSafety;
            }
            for (int[] dir : DIRECTIONS) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (isValid(nextX, nextY, n) && gridArr[nextX][nextY] != 2) {
                    pathQueue.add(new int[]{nextX, nextY, Math.min(currSafety, safety[nextX][nextY])});
                    gridArr[nextX][nextY] = 2;
                }
            }
        }
        return 0;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}

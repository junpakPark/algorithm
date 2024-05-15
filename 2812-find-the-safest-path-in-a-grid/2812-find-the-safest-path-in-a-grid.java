class Solution {
    private static final int[] DIR_X = {1, -1, 0, 0};
    private static final int[] DIR_Y = {0, 0, 1, -1};

    private int n;
    private List<List<Integer>> grid;
    private List<List<Integer>> distance;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.n = grid.size();
        this.grid = grid;
        this.distance = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
            distance.add(row);
        }

        for (List<Integer> row : distance) {
            Collections.fill(row, Integer.MAX_VALUE);
        }
        calculateMinimumDistances();

        return binarySearchMaximumSafeness();
    }

    private void calculateMinimumDistances() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new Point(i, j));
                    distance.get(i).set(j, 0);
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + DIR_X[i];
                int newY = p.y + DIR_Y[i];
                if (isValidCell(newX, newY) && distance.get(newX).get(newY) > distance.get(p.x).get(p.y) + 1) {
                    distance.get(newX).set(newY, distance.get(p.x).get(p.y) + 1);
                    queue.offer(new Point(newX, newY));
                }
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private int binarySearchMaximumSafeness() {
        int left = 0, right = n * 2, answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReachEndWithSafeness(mid)) {
                answer = mid;
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        
        return answer;
    }

    private boolean canReachEndWithSafeness(int safenessFactor) {
        if (distance.get(0).get(0) < safenessFactor) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == n - 1 && p.y == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = p.x + DIR_X[i];
                int newY = p.y + DIR_Y[i];
                if (isValidCell(newX, newY) && !visited[newX][newY] && distance.get(newX).get(newY) >= safenessFactor) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY));
                }
            }
        }

        return false;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

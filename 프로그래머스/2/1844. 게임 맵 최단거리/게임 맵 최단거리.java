
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private final Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    public int solution(int[][] maps) {
        priorityQueue.offer(new int[]{0, 0, 1});

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();

            if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                return current[2];
            }
            findPath(maps, current);
        }
        return -1;
    }

    private void findPath(final int[][] maps, final int[] current) {
        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int row = current[0], col = current[1], distance = current[2];

        for (final int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isInMaps(newRow, newCol, maps) && isPath(newRow, newCol, maps)) {
                maps[newRow][newCol] = 0;
                priorityQueue.offer(new int[]{newRow, newCol, distance + 1});
            }
        }
    }

    private boolean isInMaps(final int newRow, final int newCol, final int[][] maps) {
        int rows = maps.length - 1, cols = maps[0].length - 1;

        boolean validateRow = 0 <= newRow && newRow <= rows;
        boolean validateCol = 0 <= newCol && newCol <= cols;

        return validateRow && validateCol;
    }

    private boolean isPath(final int newRow, final int newCol, final int[][] maps) {
        return maps[newRow][newCol] == 1;
    }

}


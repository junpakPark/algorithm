class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.distance));

        for (int[] point : points) {
            long distance = (long) point[0] * point[0] + (long) point[1] * point[1];
            priorityQueue.add(new Point(distance, point));
        }

        int[][] results = new int[k][];

        for (int i = 0; i < k; i++) {
            results[i] = priorityQueue.poll().point;
        }
        return results;
    }

    private static class Point {
        private final long distance;
        private final int[] point;

        public Point(long distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

    }

}
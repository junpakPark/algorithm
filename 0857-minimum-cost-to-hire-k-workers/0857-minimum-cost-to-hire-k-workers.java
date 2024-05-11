
class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        PriorityQueue<Integer> maxQuality = new PriorityQueue<>(Collections.reverseOrder());
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;

        for (int i = 0; i < n; i++) {
            double ratio = (double) wage[i] / quality[i];
            workers[i] = new Worker(ratio, quality[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(w -> w.wagePerQualityRatio));

        for (Worker worker : workers) {
            maxQuality.offer(worker.quality);
            totalQuality += worker.quality;

            if (maxQuality.size() > k) {
                totalQuality -= maxQuality.poll();
            }

            if (maxQuality.size() == k) {
                minCost = Math.min(minCost, totalQuality * worker.wagePerQualityRatio);
            }
        }

        return minCost;
    }

    private static class Worker {
        double wagePerQualityRatio;
        int quality;

        public Worker(double ratio, int quality) {
            this.wagePerQualityRatio = ratio;
            this.quality = quality;
        }
    }
}

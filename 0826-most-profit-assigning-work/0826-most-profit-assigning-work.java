class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }

        
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.difficulty));
        Arrays.sort(worker);

        int maxProfit = 0;
        int maxSoFar = 0;
        int j = 0;

        for (int ability : worker) {
            while (j < n && jobs[j].difficulty <= ability) {
                maxSoFar = Math.max(maxSoFar, jobs[j].profit);
                j++;
            }
            maxProfit += maxSoFar;
        }

        return maxProfit;
    }

    private static class Job {
        int difficulty;
        int profit;

        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
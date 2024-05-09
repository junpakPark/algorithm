class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long answer = 0;
        int decrementCount = 0;

        Arrays.sort(happiness);

        for (int i = happiness.length - 1; i >= happiness.length - k; --i) {
            int currentHappiness = happiness[i] - decrementCount;
            answer += Math.max(0, currentHappiness);
            decrementCount++;
        }

        return answer;
    }
}
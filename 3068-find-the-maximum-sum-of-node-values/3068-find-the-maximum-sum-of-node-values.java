class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        int changedCount = 0;
        int minChangeDiff = Integer.MAX_VALUE;

        for (final int num : nums) {
            int changedValue = num ^ k;
            maxSum += Math.max(num, changedValue);
            if (changedValue > num) {
                changedCount++;
            }
            minChangeDiff = Math.min(minChangeDiff, Math.abs(num - changedValue));
        }

        if (changedCount % 2 == 0) {
            return maxSum;
        }
        return maxSum - minChangeDiff;
    }
}
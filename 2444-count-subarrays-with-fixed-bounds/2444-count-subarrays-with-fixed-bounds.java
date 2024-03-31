public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long totalSubarrays = 0;
        int lastIndex = -1;
        int min = -1;
        int max = -1;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (nums[currentIndex] < minK || nums[currentIndex] > maxK) {
                lastIndex = currentIndex;
            }
            if (nums[currentIndex] == minK) {
                min = currentIndex;
            }
            if (nums[currentIndex] == maxK) {
                max = currentIndex;
            }

            totalSubarrays += Math.max(0, Math.min(min, max) - lastIndex);
        }

        return totalSubarrays;
    }
}
class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int index = 0;
        long miss = 1;

        while (miss <= n) {
            if (index < nums.length && nums[index] <= miss) {
                miss += nums[index++];
                continue;
            }
            miss += miss;
            patches++;
        }
        return patches;
    }
}

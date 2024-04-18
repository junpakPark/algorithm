class Solution {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
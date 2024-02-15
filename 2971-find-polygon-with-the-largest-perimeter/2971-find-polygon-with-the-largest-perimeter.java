class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long prefix = 0;

        for (int num : nums) {
            prefix += num;
        }

        for (int i = nums.length - 1; i >= 2; --i) {
            prefix -= nums[i];
            if (prefix > nums[i]) {
                return prefix + nums[i];
            }
        }
        return -1L;
    }
}
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int x = nums.length - i;
            if (nums[i] >= x && (i == 0 || nums[i - 1] < x)) {
                return x;
            }
        }

        return -1;
    }
}
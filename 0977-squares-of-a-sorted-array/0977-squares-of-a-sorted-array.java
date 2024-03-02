class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        int[] results = new int[length];
        int index = length - 1;
        int squaredValue;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                squaredValue = nums[left];
                left++;
            } else {
                squaredValue = nums[right];
                right--;
            }
            results[index--] = squaredValue * squaredValue;
        }
        return results;
    }
}
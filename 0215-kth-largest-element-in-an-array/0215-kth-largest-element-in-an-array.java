class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int size = nums.length;
        
        return nums[size - k];
    }
}

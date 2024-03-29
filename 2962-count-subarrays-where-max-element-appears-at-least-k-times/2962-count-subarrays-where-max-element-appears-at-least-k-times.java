class Solution {
    public long countSubarrays(int[] nums, int k) {
        int length = nums.length;
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        
        long answer = 0;
        int count = 0;
        int end = 0;
        for (int start = 0; start < length; start++) {
            while (end < length && count < k) {
                count += nums[end] == maxValue ? 1 : 0;
                end++;
            }
            
            if (count < k) {
                break;
            }
            
            answer += length - end + 1;
            count -= nums[start] == maxValue ? 1 : 0;
        }
        return answer;
    }
}
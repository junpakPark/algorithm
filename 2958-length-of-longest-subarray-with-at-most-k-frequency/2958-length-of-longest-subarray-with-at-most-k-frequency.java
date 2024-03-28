public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            frequencies.put(nums[end], frequencies.getOrDefault(nums[end], 0) + 1);

            while (frequencies.get(nums[end]) == k + 1) {
                frequencies.put(nums[start], frequencies.get(nums[start]) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
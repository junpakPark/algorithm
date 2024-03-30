public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingDoor(nums, k) - slidingDoor(nums, k - 1);
    }

    private int slidingDoor(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            frequencies.put(nums[right], frequencies.getOrDefault(nums[right], 0) + 1);
            if (frequencies.get(nums[right]) == 1) {
                k--;
            }
            while (k < 0) {
                frequencies.put(nums[left], frequencies.get(nums[left]) - 1);
                if (frequencies.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

}

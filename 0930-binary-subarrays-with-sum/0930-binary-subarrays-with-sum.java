class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            count += counts.getOrDefault(prefixSum - goal, 0);
            counts.put(prefixSum, counts.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
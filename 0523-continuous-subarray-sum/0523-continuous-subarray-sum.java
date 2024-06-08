class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(0, -1);

        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int remainder = cumulativeSum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (remainderIndexMap.containsKey(remainder)) {
                int prevIndex = remainderIndexMap.get(remainder);
                if (i - prevIndex > 1) {
                    return true;
                }
                continue;
            }
            remainderIndexMap.put(remainder, i);
        }

        return false;
    }
}
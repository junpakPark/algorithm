class Solution {
    public int maxSubArray(int[] nums) {
        List<Integer> sums = new ArrayList<>(List.of(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int sum = 0;
            if (sums.get(i - 1) > 0) {
                sum += sums.get(i - 1);
            }
            sums.add(sum + nums[i]);
        }
        return Collections.max(sums);
    }
}
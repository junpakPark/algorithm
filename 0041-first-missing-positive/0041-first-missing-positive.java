class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                map.add(num);
            }
        }

        if (map.isEmpty()) {
            return 1;
        }

        int maxValue = Collections.max(map);

        for (int i = 1; i < maxValue; i++) {
            if (!map.contains(i)) {
                return i;
            }
        }
        return maxValue + 1;
    }
}

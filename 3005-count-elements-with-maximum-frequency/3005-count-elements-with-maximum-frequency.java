class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (final int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int max = Collections.max(frequencies.values());
        int frequency = Collections.frequency(frequencies.values(), max);

        return max * frequency;
    }
}

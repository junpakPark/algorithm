class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();
        for (final int num : nums) {
            frequent.put(num, frequent.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (final int i : frequent.keySet()) {
            priorityQueue.add(new int[]{i, frequent.get(i)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }
}
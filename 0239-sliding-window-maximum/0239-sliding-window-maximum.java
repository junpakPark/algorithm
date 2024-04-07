class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i >= k - 1) {
                results.add(nums[deque.peek()]);
            }
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}
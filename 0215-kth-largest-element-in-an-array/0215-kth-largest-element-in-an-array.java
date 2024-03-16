class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            priorityQueue.add(num);
        }
        
        for(int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        
        return priorityQueue.poll();
    }
}

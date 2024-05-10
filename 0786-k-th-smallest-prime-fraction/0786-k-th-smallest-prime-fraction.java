class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k,
                (o1, o2) -> arr[o1[0]] * arr[o2[1]] - arr[o1[1]] * arr[o2[0]]);
        
        int n = arr.length;
        int min = Math.min(k, n);
        for (int i = 0; i < min; i++) {
            queue.offer(new int[]{i, n - 1});
        }
        
        while (!queue.isEmpty() && --k > 0) {
            int[] cur = queue.poll();
            if (--cur[1] > cur[0]) {
                queue.offer(cur);
            }
        }
        return new int[]{arr[queue.peek()[0]], arr[queue.peek()[1]]};
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        priorityQueue.addAll(Arrays.asList(people));

        List<int[]> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int[] person = priorityQueue.poll();
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}

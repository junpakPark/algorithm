class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char c : tasks) {
            frequencies[c - 'A']++;
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int frequency : frequencies) {
            if (frequency > 0) {
                priorityQueue.add(frequency);
            }
        }

        int result = 0;
        while (true) {
            int intervals = 0;
            List<Integer> list = new ArrayList<>();

            while (!priorityQueue.isEmpty()) {
                int frequency = priorityQueue.poll();

                if (intervals < n + 1) {
                    intervals++;
                    result++;

                    if (frequency > 1) {
                        list.add(frequency - 1);
                    }
                } else {
                    list.add(frequency);
                }
            }

            if (list.isEmpty()) {
                break;
            }
            priorityQueue.addAll(list);
            result += n + 1 - intervals;
        }
        return result;
    }
}

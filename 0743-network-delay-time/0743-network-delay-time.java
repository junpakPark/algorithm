import java.util.AbstractMap;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (final int[] time : times) {
            graph.computeIfAbsent(time[0], node -> new HashMap<>())
                    .put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer, Integer>> nodesQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        nodesQueue.add(new AbstractMap.SimpleEntry<>(k, 0));

        Map<Integer, Integer> nodeToTime = new HashMap<>();
        while (!nodesQueue.isEmpty()) {
            Map.Entry<Integer, Integer> currentNodeEntry = nodesQueue.poll();

            int currentNode = currentNodeEntry.getKey();
            int currentTime = currentNodeEntry.getValue();

            if (!nodeToTime.containsKey(currentNode)) {
                nodeToTime.put(currentNode, currentTime);

                if (graph.containsKey(currentNode)) {
                    for (final Map.Entry<Integer, Integer> adjacentNodeEntry : graph.get(currentNode).entrySet()) {
                        int alternativeTime = currentTime + adjacentNodeEntry.getValue();
                        nodesQueue.add(new AbstractMap.SimpleEntry<>(adjacentNodeEntry.getKey(), alternativeTime));
                    }
                }
            }
        }
        if (nodeToTime.size() == n) {
            return Collections.max(nodeToTime.values());
        }
        return -1;
    }
}

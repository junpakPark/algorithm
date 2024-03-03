import java.util.Map.Entry;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (final int[] flight : flights) {
            int start = flight[0], end = flight[1], cost = flight[2];
            graph.computeIfAbsent(start, k -> new HashMap<>())
                    .put(end, cost);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.add(new int[]{src, 0, 0});

        Map<Integer, Integer> visited = new HashMap<>();

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentLocation = current[0], totalPrice = current[1], stopsMade = current[2];

            if (currentLocation == dst) {
                return totalPrice;
            }
            visited.put(currentLocation, stopsMade);

            if (stopsMade <= K) {
                int nextStops = stopsMade + 1;

                if (graph.containsKey(currentLocation)) {
                    for (final Entry<Integer, Integer> nextFlight : graph.get(currentLocation).entrySet()) {
                        Integer nextLocation = nextFlight.getKey();
                        if (!visited.containsKey(nextLocation) || nextStops < visited.get(nextLocation)) {
                            int newTotalPrice = totalPrice + nextFlight.getValue();
                            priorityQueue.add(new int[]{nextFlight.getKey(), newTotalPrice, nextStops});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
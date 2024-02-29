class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (final List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                    .add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        Deque<String> seen = new ArrayDeque<>();

        seen.push("JFK");

        
        while (!seen.isEmpty()) {
            while (map.containsKey(seen.getFirst()) && !map.get(seen.getFirst()).isEmpty()) {
                seen.push(map.get(seen.getFirst()).poll());
            }
            results.add(0, seen.pop());
        }
        return results;
    }
}
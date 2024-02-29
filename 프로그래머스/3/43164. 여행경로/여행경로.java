import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> routes = new HashMap<>();

        for (final String[] ticket : tickets) {
            routes.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
                    .add(ticket[1]);
        }

        Deque<String> results = new ArrayDeque<>();
        Deque<String> seen = new ArrayDeque<>();

        seen.push("ICN");

        while (!seen.isEmpty()) {
            while (routes.containsKey(seen.getFirst()) && !routes.get(seen.getFirst()).isEmpty()) {
                seen.push(routes.get(seen.getFirst()).poll());
            }
            results.addFirst(seen.pop());
        }

        return results.toArray(new String[0]);
    }
}

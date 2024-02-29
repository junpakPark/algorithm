import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> routes = new HashMap<>();

        for (final String[] ticket : tickets) {
            routes.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
                    .add(ticket[1]);
        }

        String[] answer = {};
        List<String> results = new LinkedList<>();
        Deque<String> seen = new ArrayDeque<>();

        seen.push("ICN");

        while (!seen.isEmpty()) {
            while (routes.containsKey(seen.getFirst()) && !routes.get(seen.getFirst()).isEmpty()) {
                seen.push(routes.get(seen.getFirst()).poll());
            }
            results.add(0, seen.pop());
        }

        return results.toArray(answer);
    }

}

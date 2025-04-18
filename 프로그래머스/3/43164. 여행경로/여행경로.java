import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        final Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
                .offer(ticket[1]);
        }
        
        final Deque<String> answer = new ArrayDeque<>();
        final Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");
        
        while(!stack.isEmpty()) {
            final String start = stack.peek();
            final PriorityQueue<String> ends = map.getOrDefault(start, new PriorityQueue<>());
            
            if (ends.isEmpty()) {
                answer.push(stack.pop());
                continue;
            }
            stack.push(ends.poll());
        }
        
        return answer.toArray(new String[0]);
    }
}
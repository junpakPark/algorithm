class Solution {

    private final Set<String> deadEnd = new HashSet<>();
    private final Set<String> visited = new HashSet<>();

    public int openLock(String[] deadends, String target) {
        deadEnd.addAll(Arrays.asList(deadends));

        return bfs(target);
    }

    private int bfs(String target) {
        Queue<String> queue = new LinkedList<>();
        visited.add("0000");
        queue.offer("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return level;
                }
                if (deadEnd.contains(current)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] digits = current.toCharArray();
                        digits[j] = (char) ((digits[j] - '0' + k + 10) % 10 + '0');
                        String next = new String(digits);
                        
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                        
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
}

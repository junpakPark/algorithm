
public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";

        if (dead.contains(start)) {
            return -1;
        }

        queue.add(new Pair<>(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair<String, Integer> p = queue.poll();
            String state = p.getKey();
            int depth = p.getValue();

            if (state.equals(target)) {
                return depth;
            }

            for (String nextState : getNextStates(state)) {
                if (!visited.contains(nextState) && !dead.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(new Pair<>(nextState, depth + 1));
                }
            }
        }

        return -1;
    }

    private List<String> getNextStates(String state) {
        List<String> nextStates = new ArrayList<>();
        char[] stateArray = state.toCharArray();

        for (int i = 0; i < 4; i++) {
            char num = stateArray[i];
            char num1 = num == '9' ? '0' : (char) (num + 1);
            char num2 = num == '0' ? '9' : (char) (num - 1);

            stateArray[i] = num1;
            nextStates.add(new String(stateArray));
            stateArray[i] = num2;
            nextStates.add(new String(stateArray));
            stateArray[i] = num;
        }

        return nextStates;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

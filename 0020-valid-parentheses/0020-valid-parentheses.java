class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put('}', '{');
        table.put(']', '[');

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);

            if (!table.containsKey(key)) {
                stack.push(key);
                continue;
            }
            if (stack.isEmpty() || table.get(key) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
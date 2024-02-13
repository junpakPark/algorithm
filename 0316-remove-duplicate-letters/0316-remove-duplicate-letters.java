class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();

        Deque<Character> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for (char character : chars) {
            counter.put(character, counter.getOrDefault(character, 0) + 1);
        }

        for (char character : chars) {
            counter.put(character, counter.get(character) - 1);

            if (seen.get(character) != null && seen.get(character)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > character && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }
            stack.push(character);
            seen.put(character, true);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
        }
        return stringBuilder.toString();
    }
}

public class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] isValid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                continue;
            }
            if (c == ')') {
                if (!stack.isEmpty()) {
                    isValid[stack.pop()] = true;
                    isValid[i] = true;
                }
                continue;
            }
            isValid[i] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isValid[i]) {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}

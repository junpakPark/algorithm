import java.util.*;

class Solution {
    boolean solution(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || stack.peek() == ')') {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}
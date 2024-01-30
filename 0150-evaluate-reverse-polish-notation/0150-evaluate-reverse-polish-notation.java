import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if (token.equals("-")) {
                Integer pop2 = stack.pop();
                Integer pop = stack.pop();
                stack.push(pop - pop2);
                continue;
            }
            if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if (token.equals("/")) {
                Integer pop2 = stack.pop();
                Integer pop = stack.pop();
                stack.push(pop / pop2);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
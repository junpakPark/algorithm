public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.toString();
    }
}
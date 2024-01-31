import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] results = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                results[prevDay] = i - prevDay;
            }
            stack.push(i);
        }
        return results;
    }
}

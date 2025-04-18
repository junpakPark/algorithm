import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        final Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, 0});
        
        int answer = 0;
        while(!stack.isEmpty()) {
            final int[] current = stack.pop();
            
            if (current[0] == numbers.length) {
                if(current[1] == target) {
                    answer++;
                }
                continue;
            }
            
            stack.push(new int[]{current[0] + 1, current[1] + numbers[current[0]]});
            stack.push(new int[]{current[0] + 1, current[1] - numbers[current[0]]});
        }
        return answer;
    }
}
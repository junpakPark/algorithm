import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        final List<Integer> answers = new ArrayList<>();
        int prev = (int) Math.ceil((100 - progresses[0]) / (double) speeds[0]);
        int count = 1;
        for (int i = 1; i < speeds.length; i++) {
            final int current = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            if (current <= prev) {
                count++;
                continue;
            }
            prev = current;
            answers.add(count);
            count = 1;
        }
        answers.add(count);
        
        final int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
}
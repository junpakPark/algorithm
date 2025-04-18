import java.util.*;

class Solution {
    
    private static final int[] one = {1, 2, 3, 4, 5};
    private static final int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        final int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            final int answer = answers[i];
            if (answer == one[i % one.length]) {
                scores[0]++;
            }
            if (answer == two[i % two.length]) {
                scores[1]++;
            }
            if (answer == three[i % three.length]) {
                scores[2]++;
            }
        }
        
        final int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        final List<Integer> results = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                results.add(i + 1);
            }
        }
        
        final int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}
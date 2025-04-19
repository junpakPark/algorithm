import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        final List<String> answer = new ArrayList<>();
        for (int number : numbers) {
            answer.add(String.valueOf(number));
        }
        
        Collections.sort(answer, (a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(answer.get(0))) {
            return "0";
        }
        return String.join("", answer);
    }
}
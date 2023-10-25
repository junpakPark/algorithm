import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (String[] people : photo) {

            int sum = 0;
            for (String person : people) {
                sum += map.getOrDefault(person, 0);
            }

            answer.add(sum);
        }

        return answer;
    }
}
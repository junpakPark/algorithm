import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int solution(String[] words) {
        Map<String, Integer> patternCount = new HashMap<>();
        for (String word : words) {
            String pattern = findPattern(word);
            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
        }

        int answer = 0;
        for (int count : patternCount.values()) {
            if (count > 1) {
                answer += combination(count, 2);
            }
        }

        return answer;
    }

    private static String findPattern(String word) {
        Map<Character, Integer> charMapping = new HashMap<>();

        int nextNumber = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            charMapping.putIfAbsent(c, nextNumber++);
            stringBuilder.append(charMapping.get(c));
        }
        return stringBuilder.toString();
    }

    private static int combination(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return combination(n - 1, k - 1) + combination(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.println(solution(words));

        bufferedReader.close();
    }

}

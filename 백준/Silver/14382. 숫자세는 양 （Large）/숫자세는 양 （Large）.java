import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String[] solution(int[] cases) {
        String[] results = new String[cases.length];

        for (int i = 0; i < cases.length; i++) {
            results[i] = String.format("Case #%d: %s", i + 1, findResult(cases[i]));
        }

        return results;
    }

    private static String findResult(int n) {
        if (n == 0) {
            return "INSOMNIA";
        }

        List<Boolean> checkedNumber = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            checkedNumber.add(false);
        }

        int i = 0;
        while (checkedNumber.contains(false)) {
            i++;
            String[] numbers = Integer.toString(i * n)
                    .split("");
            for (String s : numbers) {
                int number = Integer.parseInt(s);
                checkedNumber.set(number, true);
            }
        }

        return Integer.toString(i * n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        int[] cases = new int[t];
        for (int i = 0; i < t; i++) {
            cases[i] = Integer.parseInt(bufferedReader.readLine());
        }

        String[] results = solution(cases);
        for (String result : results) {
            System.out.println(result);
        }

        bufferedReader.close();
    }

}

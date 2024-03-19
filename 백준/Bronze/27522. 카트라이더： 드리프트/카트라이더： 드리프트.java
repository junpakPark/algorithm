import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private static void solution(String[] records) {
        Map<int[], String> board = new HashMap<>();
        List<int[]> results = new ArrayList<>();

        for (final String record : records) {
            String[] log = record.split(" ");
            int[] lapTime = calculateScore(log[0]);

            results.add(lapTime);
            board.put(lapTime, log[1]);
        }

        results.sort(Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1])
                .thenComparingInt(a -> a[2]));

        List<String> answers = new ArrayList<>();
        for (int[] result : results) {
            answers.add(board.get(result));
        }

        int blueScore = 0;
        int redScore = 0;

        int prizedScore = 10;
        int normalScore = 5;

        for (int i = 0; i < 3; i++) {
            int score = prizedScore - 2 * i;
            if (answers.get(i).equals("B")) {
                blueScore += score;
                continue;
            }
            redScore += score;
        }

        for (int i = 3; i < 8; i++) {
            int score = normalScore + 3 - i;
            if (answers.get(i).equals("B")) {
                blueScore += score;
                continue;
            }
            redScore += score;
        }

        if (blueScore > redScore) {
            STRING_BUILDER.append("Blue");
        } else {
            STRING_BUILDER.append("Red");
        }
    }

    private static int[] calculateScore(final String lapTime) {
        String[] times = lapTime.split(":");

        return new int[]{Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2])};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] records = new String[8];

        for (int i = 0; i < 8; i++) {
            records[i] = bufferedReader.readLine();
        }

        solution(records);

        System.out.println(STRING_BUILDER);
        bufferedReader.close();
    }
}

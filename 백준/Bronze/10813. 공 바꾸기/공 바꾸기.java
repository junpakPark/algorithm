import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private static void solution(int count, final List<String> move) {
        int[] arr = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            arr[i] = i;
        }

        for (final String s : move) {
            String[] split = s.split(" ");
            int temp = arr[Integer.parseInt(split[0])];
            arr[Integer.parseInt(split[0])] = arr[Integer.parseInt(split[1])];
            arr[Integer.parseInt(split[1])] = temp;
        }

        for (int i = 1; i < arr.length; i++) {
            STRING_BUILDER.append(arr[i]).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String first = bufferedReader.readLine();
        String[] split = first.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        List<String> move = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            move.add(bufferedReader.readLine());
        }

        solution(n, move);

        System.out.println(STRING_BUILDER);
        bufferedReader.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bufferedReader.readLine());

        STRING_BUILDER.append(new BigInteger("2").pow(count).subtract(BigInteger.ONE)).append('\n');

        if (count <= 20) {
            hanoi(count, 1, 3, 2);
        }

        System.out.println(STRING_BUILDER);
        bufferedReader.close();
    }

    private static void hanoi(int count, int from, int to, int temp) {
        if (count == 0) {
            return;
        }
        hanoi(count - 1, from, temp, to);
        STRING_BUILDER.append(from + " " + to + "\n");
        hanoi(count - 1, temp, to, from);
    }

}

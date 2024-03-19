import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long solution(final int[] trees, final int cost, final int price) {
        int longest = 0;
        for (int tree : trees) {
            if (tree > longest) {
                longest = tree;
            }
        }

        long result = 0;
        for (int i = 1; i <= longest; i++) {
            long sum = 0;
            for (int tree : trees) {
                int count = tree / i;
                int remain = tree % i;

                long expense = (remain > 0) ? (long) count * cost : (long) (count - 1) * cost;
                long target = ((long) count * price * i) - expense;

                sum += Math.max(0, target);
            }
            result = Math.max(sum, result);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int cost = Integer.parseInt(tokenizer.nextToken());
        int price = Integer.parseInt(tokenizer.nextToken());

        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(solution(trees, cost, price));

        bufferedReader.close();
    }

}

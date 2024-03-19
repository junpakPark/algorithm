import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int solution(final int n, final int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.offer(queue.poll());
            for (int i = 0; i < k - 1; i++) {
                queue.poll();
                if (queue.size() == 1) {
                    break;
                }
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String row = bufferedReader.readLine();
        String[] split = row.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        System.out.println(solution(n, k));

        bufferedReader.close();
    }

}

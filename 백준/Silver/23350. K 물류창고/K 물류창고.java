import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int solution(int m, int[][] containers) {
        int[] priorities = new int[m + 1];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] container : containers) {
            queue.offer(container);
            priorities[container[0]]++;
        }

        int cost = 0;
        Map<Integer, List<Integer>> wareHouses = new HashMap<>();
        wareHouses.put(m, new ArrayList<>());
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            cost += current[1];

            if (m != current[0]) {
                queue.offer(current);
                continue;
            }

            priorities[m]--;
            if (priorities[m] == 0) {
                m--;
                wareHouses.put(m, new ArrayList<>());
            }

            List<Integer> wareHouse = wareHouses.get(current[0]);
            if (wareHouse.isEmpty()) {
                wareHouse.add(current[1]);
                continue;
            }
            for (int storage : wareHouse) {
                if (storage >= current[1]) {
                    break;
                }
                cost += storage * 2;
            }
            wareHouse.add(current[1]);
            Collections.sort(wareHouse);
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] containers = new int[n][2];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            containers[i] = new int[]{Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())};
        }

        System.out.println(solution(m, containers));

        bufferedReader.close();
    }

}

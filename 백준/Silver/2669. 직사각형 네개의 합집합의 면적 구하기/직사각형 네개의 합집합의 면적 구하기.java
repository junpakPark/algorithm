import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] graph = new int[100][100];
        
        for (int t = 0; t < 4; t++) {
            String[] parts = br.readLine().split(" ");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    graph[i][j] = 1;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                result += graph[i][j];
            }
        }
        
        System.out.println(result);
    }
}

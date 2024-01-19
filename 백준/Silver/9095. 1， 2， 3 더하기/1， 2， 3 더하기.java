import java.io.*;

public class Main {
    
    private static int[] calculateWays() {
        int[] ways = new int[11];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;

        for (int i = 4; i <= 10; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }

        return ways;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] waysToMakeNumber = calculateWays();

        int testCases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < testCases; i++) {
            int numberToCheck = Integer.parseInt(bufferedReader.readLine());
            bufferedWriter.write(waysToMakeNumber[numberToCheck] + "\n");
        }
        
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

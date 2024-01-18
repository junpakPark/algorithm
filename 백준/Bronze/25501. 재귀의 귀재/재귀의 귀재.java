import java.io.*;

public class Main {

    private static int recursionCount;

    private static boolean isPalindromeRecursive(String s, int left, int right) {
        recursionCount++;
        if (left >= right) {
            return true;
        } 
        return s.charAt(left) == s.charAt(right) && isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static boolean isPalindrome(String s) {
        recursionCount = 0;
        return isPalindromeRecursive(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        StringBuilder resultBuilder = new StringBuilder(testCases * 4); // 각 테스트 케이스 결과는 대략 4자리를 차지할 것입니다.

        for (int i = 0; i < testCases; i++) {
            String inputString = bufferedReader.readLine();
            boolean isInputPalindrome = isPalindrome(inputString);
            resultBuilder.append(isInputPalindrome ? 1 : 0)
                         .append(" ")
                         .append(recursionCount)
                         .append("\n");
        }

        bufferedWriter.write(resultBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

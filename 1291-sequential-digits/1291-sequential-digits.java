import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();

        List<Integer> result = new ArrayList<>();

        for (int length = lowLength; length <= highLength; length++) {
            for (int i = 0; i < 10 - length; i++) {
                int num = Integer.parseInt(digits.substring(i, i + length));
                if (low <= num && num <= high) {
                    result.add(num);
                }
            }
        }
        return result;
    }
}

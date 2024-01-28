import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        for (int colStart = 0; colStart < cols; colStart++) {
            for (int colEnd = colStart; colEnd < cols; colEnd++) {
                Map<Integer, Integer> cumulativeSumFreq = new HashMap<>();
                cumulativeSumFreq.put(0, 1);
                int sum = 0;

                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][colEnd] - (colStart > 0 ? matrix[row][colStart - 1] : 0);
                    count += cumulativeSumFreq.getOrDefault(sum - target, 0);
                    cumulativeSumFreq.put(sum, cumulativeSumFreq.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
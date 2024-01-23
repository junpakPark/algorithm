import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        List<String> results = new ArrayList<>();
        backtrack(arr, 0, "", results);
        int maxLength = 0;

        for (String result : results) {
            maxLength = Math.max(maxLength, result.length());
        }
        return maxLength;
    }

    private void backtrack(List<String> arr, int start, String current, List<String> results) {
        if (isUnique(current)) {
            results.add(current);
        } else {
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            backtrack(arr, i + 1, current + arr.get(i), results);
        }
    }

    private boolean isUnique(String current) {
        boolean[] charMap = new boolean[256];

        for (char c : current.toCharArray()) {
            if (charMap[c]) {
                return false;
            }
            charMap[c] = true;
        }
        return true;
    }
}

public class Solution {
    public boolean checkValidString(String s) {
        int minCount = 0; 
        int maxCount = 0; 

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(0, minCount - 1);
                maxCount--;
            } else {
                minCount = Math.max(0, minCount - 1);
                maxCount++;
            }

            if (maxCount < 0) {
                return false;
            }
        }
        return minCount == 0;
    }
}
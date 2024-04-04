public class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0; 
        int currentDepth = 0; 
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++; 
                maxDepth = Math.max(maxDepth, currentDepth);
                continue;
            }
            if (c == ')') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
}
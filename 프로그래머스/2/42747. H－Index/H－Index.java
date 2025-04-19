import java.util.*;

class Solution {
    public int solution(int[] citations) {
        final int n = citations.length;
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            int citation = citations[i];
            if(citation >= n - i) {
                return n - i;
            }
        }
        
        return 0;
    }
}
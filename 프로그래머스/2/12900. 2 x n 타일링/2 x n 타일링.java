class Solution {
    
    private static final int mod = 1_000_000_007;
    
    public int solution(int n) {
        if (n <= 2) {
            return n;
        }
        
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            final int temp = (a + b) % mod;
            a = b;
            b = temp;
        }
        
        return b;
    }
}
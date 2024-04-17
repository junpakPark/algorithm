class Solution {
    public int fib(int n) {
        int x = 0, y = 1;
        for (int i = 0; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return x;
    }
}
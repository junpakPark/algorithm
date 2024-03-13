class Solution {
    public int pivotInteger(int n) {
        final int totalSum = (n + 1) * n / 2;
        final int sqr = (int) Math.sqrt(totalSum);
        
        if(sqr * sqr == totalSum) {
            return sqr;
        }
        return -1;
    }
}

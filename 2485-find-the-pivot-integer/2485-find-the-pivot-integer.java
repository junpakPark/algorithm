class Solution {
    public int pivotInteger(int n) {
        int[] prefixSum = new int[n+1];

        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }

        for (int i = 1; i < n + 1; i++) {
            if (prefixSum[i] == prefixSum[n] - prefixSum[i - 1])
                return i;
        }

        return -1;
    }
}
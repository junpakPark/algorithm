class Solution {
    public int minOperations(int[] nums, int k) {
        int xorSum = 0;
		for (int num : nums) {
			xorSum ^= num;
		}

		int xorWithK = xorSum ^ k;

		return Integer.bitCount(xorWithK);
    }
}
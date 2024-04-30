class Solution {
	public long wonderfulSubstrings(String word) {
		int[] bitmaskCount = new int[1 << 10];
		bitmaskCount[0] = 1;
		long result = 0;
		int currentMask = 0; // Current bitmask state

		for (char c : word.toCharArray()) {
			currentMask ^= 1 << (c - 'a');
			result += bitmaskCount[currentMask];
			for (int i = 0; i < 10; ++i) {
				result += bitmaskCount[currentMask ^ (1 << i)];
			}
			++bitmaskCount[currentMask];
		}
		return result;
	}
}
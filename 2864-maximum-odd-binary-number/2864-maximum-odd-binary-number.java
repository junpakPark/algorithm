class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zero = 0;
        int one = 0;

        for (final char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
                continue;
            }
            if (c == '1') {
                one++;
            }
        }
        return "1".repeat(one - 1) + "0".repeat(zero) + 1;
    }
}
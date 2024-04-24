class Solution {
    public int getSum(int a, int b) {
        String binaryStringA = toBinaryString(a);
        String binaryStringB = toBinaryString(b);

        List<Character> resultDigits = new ArrayList<>();
        int carry = 0;
        int sumBit;

        for (int i = 0; i < 32; i++) {
            int bit1 = getBitAt(binaryStringA, i);
            int bit2 = getBitAt(binaryStringB, i);

            int andBits = bit1 & bit2;
            int xorBits = bit1 ^ bit2;
            int carryAndXor = xorBits & carry;

            sumBit = carry ^ xorBits;
            carry = andBits | carryAndXor;
            
            resultDigits.add(0, Character.forDigit(sumBit, 2));
        }

        String binaryResult = resultDigits.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return Integer.parseUnsignedInt(binaryResult, 2);
    }

    private int getBitAt(final String binaryString, final int position) {
        return Character.getNumericValue(binaryString.charAt(31 - position));
    }

    private String toBinaryString(final int number) {
        return String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
    }
}

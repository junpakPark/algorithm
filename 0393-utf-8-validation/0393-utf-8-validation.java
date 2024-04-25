class Solution {
    public boolean validUtf8(int[] data) {
        int start = 0;

        while (start < data.length) {
            int first = data[start];
            if (first >> 3 == 0b11110 && check(data, start, 3)) {
                start += 4;
                continue;
            }
            if (first >> 4 == 0b1110 && check(data, start, 2)) {
                start += 3;
                continue;
            }
            if (first >> 5 == 0b110 && check(data, start, 1)) {
                start += 2;
                continue;
            }
            if (first >> 7 == 0) {
                start++;
                continue;
            }
            return false;

        }
        return true;
    }

    private boolean check(int[] data, int start, int size) {
        for (int i = start + 1; i < start + size + 1; i++) {
            if (i >= data.length || data[i] >> 6 != 0b10) {
                return false;
            }
        }
        return true;
    }
}

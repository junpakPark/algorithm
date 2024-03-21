
class Solution {

    private boolean[] fullBinary;
    private int possible;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < answer.length; i++) {
            fullBinary = convertToBinary(numbers[i]);
            possible = 1;
            dfs(0, fullBinary.length - 1, false);
            answer[i] = possible;
        }

        return answer;
    }

    private boolean[] convertToBinary(long number) {
        String binary = Long.toBinaryString(number);

        int fullLength = 0;
        int h = 1;
        while (fullLength < binary.length()) {
            fullLength = (int) Math.pow(2, h++) - 1;
        }

        boolean[] fullBinary = new boolean[fullLength];

        int index = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            fullBinary[i] = binary.charAt(index++) == '1';
        }

        return fullBinary;
    }

    private void dfs(int start, int end, boolean parentRoot) {
        if (possible == 0) {
            return;
        }

        int mid = (start + end) / 2;
        if (parentRoot && fullBinary[mid]) {
            possible = 0;
            return;
        }

        if (start != end) {
            dfs(start, mid - 1, !fullBinary[mid]);
            dfs(mid + 1, end, !fullBinary[mid]);
        }
    }
}

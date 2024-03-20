class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int column = board[0].length;

        int[][] prefixSum = new int[row + 1][column + 1];
        for (int[] s : skill) {
            int flag = (s[0] == 1) ? -1 : 1;

            prefixSum[s[1]][s[2]] += s[5] * flag;
            prefixSum[s[1]][s[4] + 1] -= s[5] * flag;
            prefixSum[s[3] + 1][s[2]] -= s[5] * flag;
            prefixSum[s[3] + 1][s[4] + 1] += s[5] * flag;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }

        for (int j = 0; j < column; j++) {
            for (int i = 1; i < row; i++) {
                prefixSum[i][j] += prefixSum[i - 1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
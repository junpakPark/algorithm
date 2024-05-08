class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];

        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            int index = scoreWithIndex[i][1];
            
            if (i == 0) {
                answer[index] = "Gold Medal";
                continue;
            }
            if (i == 1) {
                answer[index] = "Silver Medal";
                continue;
            }
            if (i == 2) {
                answer[index] = "Bronze Medal";
                continue;
            }
            answer[index] = String.valueOf(i + 1);
        }

        return answer;
    }
}
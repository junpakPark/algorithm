class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int score = 0, maxScore = 0;
        int left = 0, right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
                continue;
            }
            if (score > 0) {
                power += tokens[right--];
                score--;
                continue;
            }
            break;
        }
        return maxScore;
    }
}
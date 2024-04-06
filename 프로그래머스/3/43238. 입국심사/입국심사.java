class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1L;
        long max = 0L;
        for (int time : times) {
            max = Math.max(max, time);
        }
        long right = max * n;
        long mid = right;

        while (left <= right) {
            long calcN = 0L;
            for (int time : times) {
                calcN += (mid / time);
            }

            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = left + (right - left) / 2;
        }

        return answer;
    }
}

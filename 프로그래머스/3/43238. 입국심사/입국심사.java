class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long left = 1;
        long maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        long right = maxTime * (long) n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long processed = 0;
            for (int time : times) {
                processed += mid / time;
            }

            if (processed >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return answer;
    }
}

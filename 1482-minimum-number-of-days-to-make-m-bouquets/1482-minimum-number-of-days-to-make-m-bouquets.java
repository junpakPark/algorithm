class Solution {
  public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (getBouquetCount(bloomDay, k, mid) >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    
    private int getBouquetCount(int[] bloomDay, int k, int waitingDays) {
        int bouquetCount = 0;
        int flowersRequired = k;

        for (final int day : bloomDay) {
            if (day > waitingDays) {
                flowersRequired = k;
            } else if (--flowersRequired == 0) {
                ++bouquetCount;
                flowersRequired = k;
            }
        }

        return bouquetCount;
    }
}
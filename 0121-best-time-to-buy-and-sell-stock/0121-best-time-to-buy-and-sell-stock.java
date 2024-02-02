class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int end = prices.length - 1;

        int lowPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            lowPrice = Math.min(price, lowPrice);
            maxProfit = Math.max(price - lowPrice, maxProfit);
        }
        return maxProfit;
    }
}
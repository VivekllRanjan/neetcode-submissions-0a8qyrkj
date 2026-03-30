class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for(int sell : prices) {
            maxProfit = Math.max(maxProfit, sell - minPrice);
            minPrice = Math.min(minPrice, sell);
        }

        return maxProfit;
    }
}

public class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return rec(prices, 0, 0);
    }

    private int rec(int[] prices, int i, int bought) {
        if (i == prices.length) return 0;

        if (dp[i][bought] != null) return dp[i][bought];

        int skip = rec(prices, i + 1, bought);

        int action;
        if (bought == 1) {
            action = prices[i] + rec(prices, i + 1, 0); // sell
        } else {
            action = -prices[i] + rec(prices, i + 1, 1); // buy
        }

        return dp[i][bought] = Math.max(skip, action);
    }
}
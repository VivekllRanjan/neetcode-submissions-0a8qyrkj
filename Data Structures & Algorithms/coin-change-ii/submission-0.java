class Solution {
    Integer[][] dp;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new Integer[n][amount + 1];

        return solve(n - 1, amount, coins);
    }

    private int solve(int i, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (i < 0) return 0;

        if (dp[i][amount] != null) return dp[i][amount];

        int notTake = solve(i - 1, amount, coins);

        int take = 0;
        if (coins[i] <= amount) {
            take = solve(i, amount - coins[i], coins);
        }

        return dp[i][amount] = take + notTake;
    }
}

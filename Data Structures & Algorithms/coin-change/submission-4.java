class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        } 
        int ans = dfs(n - 1, coins, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int dfs(int i, int[] coins, int amount) {
        if(i == 0){
            if(amount % coins[i] == 0) return amount / coins[i];
            else return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int notTake = dfs(i - 1, coins, amount);
        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int res = dfs(i, coins, amount - coins[i]);
            if(res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        return dp[i][amount] = Math.min(take, notTake);
    }
}

class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(n-1, cost), dfs(n - 2, cost));
    }
    private int dfs(int idx, int[] cost) {
        if (idx == 0) return cost[0];
        if (idx == 1) return cost[1];

        if (dp[idx] != -1) return dp[idx];

        return dp[idx] = cost[idx] + Math.min(dfs(idx - 1, cost), dfs(idx - 2, cost));
    }
}

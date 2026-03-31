class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(nums, n-1);
    }

    private int dfs(int[] nums, int idx) {
        if(idx < 0) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + dfs(nums, idx - 2);
        int skip = dfs(nums, idx - 1);

        return dp[idx] = Math.max(pick, skip);
    }
}

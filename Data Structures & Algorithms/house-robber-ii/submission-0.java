class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            robRange(nums, 0, n - 2),
            robRange(nums, 1, n - 1)
        );
    }
    private int robRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return helper(nums, start, end, dp);
    }


    int helper(int[] nums, int idx, int end, int[] dp) {
        if(idx > end) return 0;
        if (dp[idx] != -1) return dp[idx];
        return dp[idx] = Math.max(helper(nums, idx + 2, end, dp) + nums[idx], helper(nums, idx + 1, end, dp));
    }
}

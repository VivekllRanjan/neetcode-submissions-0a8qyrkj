class Solution {
    Integer[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if ((target + total) % 2 != 0 || target > total) return 0;

        int sum = (target + total) / 2;

        dp = new Integer[nums.length][sum + 1];
        return solve(nums.length - 1, sum, nums);
    }

    private int solve(int i, int sum, int[] nums) {
        if (i == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }

        if (dp[i][sum] != null) return dp[i][sum];

        int notTake = solve(i - 1, sum, nums);

        int take = 0;
        if (nums[i] <= sum) {
            take = solve(i - 1, sum - nums[i], nums);
        }

        return dp[i][sum] = take + notTake;
    }
}
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, 0, dp);
    }
    int f(int[] nums, int idx, int[] dp) {
        if(idx >=nums.length) return 0;
        if(dp[idx] != -1) return dp[idx]; 
        int pick = f(nums, idx + 2, dp) + nums[idx];
        int skip = f(nums, idx + 1, dp);

        return dp[idx] = Math.max(pick, skip);
    }
}

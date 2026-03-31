class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int num : nums) totSum+=num;
        if(totSum % 2 != 0) return false;
        int target = totSum/2;

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 1; t <= target; t++) {
                boolean skip = dp[i-1][t];
                boolean pick = false;
                if(t >= nums[i]){
                    pick = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = pick || skip;
            }
        }
        return dp[n-1][target];
    }
}
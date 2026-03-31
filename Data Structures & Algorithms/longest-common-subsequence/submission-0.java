class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        Integer[][] dp = new Integer[n][m];
        return solve(n-1, m-1, text1, text2, dp);
    }

    private int solve(int i, int j, String s1, String s2, Integer[][] dp) {
        if(i <0 || j < 0) {
            return 0;
        }

        if(dp[i][j] != null) return dp[i][j];

        //match
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2, dp);
        }
        //not-match
        else {
            return dp[i][j] = (Math.max(
                solve(i - 1, j, s1, s2, dp),
                solve(i, j - 1, s1, s2, dp)
            ));
        }
    }
}
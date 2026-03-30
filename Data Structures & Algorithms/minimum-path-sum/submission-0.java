class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return f(grid, m - 1, n - 1, dp);
    }

    int f(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return grid[0][0];
        if(m < 0 || n < 0) return (int)1e9;
    
        if(dp[m][n] != -1) return dp[m][n];
        int left = grid[m][n] + f(grid, m, n - 1, dp);
        int up = grid[m][n] + f(grid, m - 1, n, dp);

        return dp[m][n] = Math.min(left, up);
    }
}
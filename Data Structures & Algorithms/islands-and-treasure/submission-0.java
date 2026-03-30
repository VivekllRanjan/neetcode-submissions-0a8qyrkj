class Solution {
    private int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private int INF = Integer.MAX_VALUE;

    private void dfs(int[][]grid, int r, int c, int dist) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
            grid[r][c] < dist){
                return;
        }

        grid[r][c] = dist;

        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1], dist + 1);
        }

    }

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }
    }
}

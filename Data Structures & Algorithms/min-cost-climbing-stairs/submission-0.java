class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int cache[] = new int [cost.length];
        for(int i =0; i  < cost.length; i++) cache[i] = -1;
        return Math.min(dfs(cost, 0, cache), dfs(cost, 1, cache)); 
    }

    private int dfs(int[] cost, int i, int[] cache) {
        if(i >= cost.length) return 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = cost[i] + Math.min(dfs(cost, i + 1, cache), dfs(cost, i + 2, cache));
    }
}

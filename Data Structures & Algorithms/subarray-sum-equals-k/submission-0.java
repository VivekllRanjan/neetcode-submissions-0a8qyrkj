class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            if(prefix.containsKey(diff)) {
                ans += prefix.get(diff);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
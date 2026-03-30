class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        compute(0, target, nums, new ArrayList<>());
        return res;
    }

    private void compute(int idx, int target, int[] nums, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        if (target < 0 || idx >= nums.length) {
            return;
        }

        //add
        curr.add(nums[idx]);
        compute(idx, target - nums[idx], nums, curr);
        
        //backtrack
        curr.remove(curr.size() - 1);

        //skip
        compute(idx+1, target, nums, curr);
    }
}

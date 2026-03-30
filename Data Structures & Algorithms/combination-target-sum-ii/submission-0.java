class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        compute(candidates, ans, new ArrayList<>(), target, 0);

        return ans;
    }
    private void compute(int[] nums, List<List<Integer>> ans, List<Integer> curr, int t, int idx) {
        if(t == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < nums.length; i++) {

            if(i > idx && nums[i] == nums[i-1]) continue;
            if (nums[i] > t) break;

            curr.add(nums[i]);
            compute(nums, ans, curr, t - nums[i], i + 1);
            curr.remove(curr.size() - 1);
        }


    }
}

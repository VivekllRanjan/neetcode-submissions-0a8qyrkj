class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        create(0, nums, new ArrayList<>());
        return ans;
    }

    private void create(int idx, int[] nums, List<Integer> curr) {
        if(idx == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        //pick
        curr.add(nums[idx]);
        create(idx + 1, nums, curr);

        //backtrack
        curr.remove(curr.size() - 1);

        //skip
        create(idx + 1, nums, curr);
    }
}

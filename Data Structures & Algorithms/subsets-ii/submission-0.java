class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int start, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));

        for(int i = start; i < arr.length; i++) {
            if(i > start && arr[i] == arr[i-1]) continue;

            curr.add(arr[i]);
            backtrack(arr,i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }

    }

}
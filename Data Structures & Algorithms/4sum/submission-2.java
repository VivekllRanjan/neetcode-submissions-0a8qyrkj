class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = n-1; j >= i+3; j--) {
                if(j < n-1 && nums[j] == nums[j+1]) continue;
                int l = i+1, r = j-1;
                while(l<r){
                    long sum = (long) nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r], nums[j]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }
                    else if(sum < target) l++;
                    else r--;
                }
            }
        }

        return result;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int ans = -1, count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                ans = nums[i]; //Assume new candidate and begin counting
                count = 1;
            }
            
            else if(nums[i] == ans) {
                count++;
            }
            else {
                count--;
            }
        }

        return ans;
    }
}
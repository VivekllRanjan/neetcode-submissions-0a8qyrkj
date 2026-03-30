class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //At max only 2 numbes can be in the answer list which appear more than n/3 times

        int num1 = -1, num2 = -1;
        int cnt1 = 0, cnt2 = 0;
        
        for(int num : nums) {
            if(num == num1) cnt1++;
            else if(num == num2) cnt2++;

            else if(cnt1 == 0) {
                cnt1 = 1;
                num1 = num;
            }
            else if(cnt2 == 0) {
                cnt2 = 1;
                num2 = num;
            }
            else{
                cnt1--; cnt2--;
            }
        }

        cnt1 = cnt2 = 0;
        for(int num : nums) {
            if(num == num1) cnt1++;
            else if(num == num2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1 > nums.length/3) ans.add(num1);
        if(cnt2 > nums.length/3) ans.add(num2);

        return ans;
    }
}
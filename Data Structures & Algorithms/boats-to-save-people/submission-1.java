class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int l = 0, r= people.length - 1;
        
        while(l <= r) {
            int diff = limit - people[r];
            res++;
            r--;

            if(l <=r && diff >= people[l]){
                l++;
            }
        }
        return res;
    }
}